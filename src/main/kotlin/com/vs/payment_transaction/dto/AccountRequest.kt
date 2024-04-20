package com.vs.payment_transaction.dto

data class AccountRequest(
    var userId: Long? = null,
    var name: String? = null,
    var amount: Double? = null
)
