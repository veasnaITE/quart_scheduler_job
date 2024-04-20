package com.vs.payment_transaction.dto

data class PaymentTranRequest(
    var merchantId: Long? = null,
    var userId : Long? = null,
    var totalPaid: Double? = null,
    var paymentMethod: String? = null
)
