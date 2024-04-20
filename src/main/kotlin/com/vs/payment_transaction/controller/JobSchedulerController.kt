package com.vs.payment_transaction.controller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.JobInfo
import com.vs.payment_transaction.dto.JobRequest
import com.vs.payment_transaction.scheduller.JobService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scheduler")
class JobSchedulerController (
    private val jobService: JobService
){
    @PostMapping("/create")
    fun create(@RequestBody req: JobRequest): MessageResponse {
        return jobService.create(req)
    }
    @PostMapping("/pause/{name}")
    fun pauseJob(@PathVariable name : String) : MessageResponse {
        return jobService.pauseJob(name)
    }
    @DeleteMapping("/delete/{name}")
    fun delete(@PathVariable name: String): MessageResponse {
        return jobService.deleteJob(name)
    }
    @PostMapping("/resume/{name}")
    fun resumeJob(@PathVariable name: String) : MessageResponse {
        return jobService.resumeJob(name)
    }
    @PutMapping("/update/{name}")
    fun update(@PathVariable name: String, @RequestBody req: JobRequest) : MessageResponse {
        req.name = name
        return jobService.updateJob(name,req)
    }
    @GetMapping
    fun getAll(): ObjectResponse<List<JobInfo>> {
        return jobService.findAll()
    }
}