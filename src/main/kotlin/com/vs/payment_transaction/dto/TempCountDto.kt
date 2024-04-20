package com.vs.payment_transaction.dto;

data class TempCountDto(
    var userId: Long? = null,
    var merchantId : Long? = null,
    var count: Long? = null,
    var sum : Double? = null
)
