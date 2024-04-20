package com.vs.payment_transaction.dto

data class JobInfo(
    val jobName: String,
    val jobClass: String,
    val description: String?, // Made description nullable
    val cronExpression: String?, // Made cronExpression nullable
    val status: String,
)