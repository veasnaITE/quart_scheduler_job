package com.vs.payment_transaction.dto
import java.math.BigDecimal

data class PaymentTranDto(
    var merchant: MerchantDto? = null,
    var userId : Long? = null,
    var totalPaid: Double? = null,
    var paymentMethod: String? = null
)
