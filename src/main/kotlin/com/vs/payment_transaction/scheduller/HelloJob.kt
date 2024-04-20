package com.vs.payment_transaction.scheduller

import org.quartz.Job
import org.quartz.JobExecutionContext

class HelloJob: Job {
    override fun execute(p0: JobExecutionContext?) {
        println("hello")
    }
}