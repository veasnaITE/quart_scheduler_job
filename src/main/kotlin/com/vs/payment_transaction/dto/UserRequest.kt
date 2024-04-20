package com.vs.payment_transaction.dto

data class UserRequest(
    var firstName: String? = null,
    var lastName: String? = null,
    var address: String? = null
)
