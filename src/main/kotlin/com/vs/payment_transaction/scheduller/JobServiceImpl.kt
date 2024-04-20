package com.vs.payment_transaction.scheduller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.base.response.ResponseMessage
import com.vs.payment_transaction.dto.JobInfo
import com.vs.payment_transaction.dto.JobRequest
import org.quartz.*
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class JobServiceImpl(
    private val scheduler: Scheduler,
): JobService {
    override fun create(req: JobRequest): MessageResponse {
        val jobClass = getClassFromInput(req.jobClass!!)
        try {
            val jobDetail = buildJobDetail(jobClass!!, req)
            val jobName = jobDetail.key.name
            println("job name: $jobName")
            val trigger = if(req.isCronTrigger){
                buildCronTrigger(jobDetail, req.cronPattern!!)
            }else{
                buildTrigger(jobDetail, req.repeatTime!!)
            }
            scheduler.scheduleJob(jobDetail , trigger)
            val res = "${jobClass.simpleName} scheduling successful"
            return MessageResponse(
                ResponseMessage(message = res)
            )
        } catch (e: SchedulerException) {
            val res = "Error while scheduling job, try again later"
            return MessageResponse(
               ResponseMessage().error()
            )
        }
    }

    override fun pauseJob( jobName : String): MessageResponse {
        try {
            if (scheduler.getJobDetail(JobKey.jobKey(jobName)) != null) {
                scheduler.pauseJob(JobKey.jobKey(jobName))
                return MessageResponse(
                    ResponseMessage(message = "Job '$jobName' paused successfully")
                )
            } else {
                return MessageResponse(ResponseMessage().error())
            }
        } catch (e: SchedulerException) {
            return MessageResponse(ResponseMessage().error())
        }
    }

    override fun resumeJob(jobName: String): MessageResponse {
        try {
            if (scheduler.getJobDetail(JobKey.jobKey(jobName)) != null) {
                scheduler.resumeJob(JobKey.jobKey(jobName))
                return MessageResponse(ResponseMessage(message = "Job '$jobName' resume successfully"))
            } else {
                return MessageResponse(ResponseMessage().error())
            }
        } catch (e: SchedulerException) {
            return MessageResponse(ResponseMessage().error())
        }
    }

    override fun deleteJob(jobName: String): MessageResponse {
        try {
            if (scheduler.getJobDetail(JobKey.jobKey(jobName)) != null) {
                scheduler.deleteJob(JobKey.jobKey(jobName))
                return MessageResponse(ResponseMessage(message = "Job '$jobName' delete successfully"))
            } else {
                return MessageResponse(ResponseMessage().error())
            }
        } catch (e: SchedulerException) {
            return MessageResponse(ResponseMessage().error())
        }
    }

    override fun findAll(): ObjectResponse<List<JobInfo>> {
        val jobInfos = mutableListOf<JobInfo>()
        val jobKeys = scheduler.getJobKeys(null)
        for (jobKey in jobKeys) {

            val jobDetail = scheduler.getJobDetail(jobKey)
            val trigger = scheduler.getTriggersOfJob(jobKey).firstOrNull()

            val jobInfo = JobInfo(
                jobName = jobDetail.key.name,
                jobClass = jobDetail.jobClass.name,
                description = jobDetail.description,
                cronExpression = trigger?.let {
                    if (it is CronTrigger) it.cronExpression else "Simple Trigger"
                } ?: "No Trigger",
                status = scheduler.getTriggerState(trigger!!.key).name
            )
            jobInfos.add(jobInfo)
        }
        return ObjectResponse(jobInfos)
    }

    override fun updateJob(jobName: String, req: JobRequest): MessageResponse {
        try {
            val jobKey = JobKey.jobKey(jobName)
            val jobDetail = scheduler.getJobDetail(jobKey)
            if (jobDetail != null) {
                // Update the job detail based on the request
                val updatedJobDetail = buildJobDetail(jobDetail.jobClass, req)
                // Get the existing trigger associated with the job
                val triggers = scheduler.getTriggersOfJob(jobKey)
                if (triggers.isNotEmpty()) {
                    // Update the trigger based on the request
                    val trigger = if(req.isCronTrigger){
                        buildCronTrigger(updatedJobDetail, req.cronPattern!!)
                    }else{
                        buildTrigger(updatedJobDetail,req.repeatTime!!)
                    }
                    // Reschedule the job with the updated trigger
                    scheduler.rescheduleJob(triggers.first().key, trigger)
                    return MessageResponse(ResponseMessage(message = "Job '$jobName' updated successfully"))
                } else {
                    return MessageResponse(ResponseMessage().error())
                }
            } else {
                return MessageResponse(ResponseMessage().error())
            }
        } catch (e: SchedulerException) {
            return MessageResponse(ResponseMessage().error())
        }
    }

    private fun buildJobDetail(jobClass: Class<out Job>, req: JobRequest) = JobBuilder.newJob(jobClass)
        .withIdentity(req.name)
        .withDescription(req.description)
        .storeDurably()
        .build()

    private fun buildTrigger(jobDetail: JobDetail,repeatTime:Long) = TriggerBuilder.newTrigger()
        .forJob(jobDetail)
        .withIdentity("${jobDetail.key.name}-records-trigger")
        .withDescription(jobDetail.description)
        .startAt(Date.from(Instant.now()))
        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
            .withIntervalInMilliseconds(repeatTime)
            .repeatForever())
        .build()

    private fun buildCronTrigger(jobDetail: JobDetail, cronPattern: String) = TriggerBuilder.newTrigger()
        .forJob(jobDetail)
        .withIdentity("${jobDetail.key.name}-records-trigger")
        .withDescription(jobDetail.description)
        .withSchedule(CronScheduleBuilder.cronSchedule(cronPattern))
        .build()

    val classMap = mapOf(
        "CountAndSumAmountJob" to CountAndSumAmountJob::class.java,
        "HelloJob" to HelloJob::class.java
    )
    private fun getClassFromInput(className: String): Class<out Job>?{
        return classMap[className]
    }

}