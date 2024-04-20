package com.vs.payment_transaction.scheduller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.JobInfo
import com.vs.payment_transaction.dto.JobRequest
import org.springframework.http.ResponseEntity

interface JobService {
    fun create(req: JobRequest): MessageResponse
    fun pauseJob(jobName: String): MessageResponse
    fun resumeJob( jobName: String): MessageResponse
    fun deleteJob(jobName: String): MessageResponse
    fun findAll(): ObjectResponse<List<JobInfo>>
    fun updateJob(jobName: String, req: JobRequest): MessageResponse
}