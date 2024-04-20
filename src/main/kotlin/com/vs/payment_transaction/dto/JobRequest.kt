package com.vs.payment_transaction.dto


data class JobRequest(
    var name: String? = null,
    var description: String? = null,
    var jobClass: String? = null,
    var repeatTime: Long? = null,
    var isCronTrigger: Boolean = false,
    var cronPattern: String? = null
)