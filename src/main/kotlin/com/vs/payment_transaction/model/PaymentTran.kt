package com.vs.payment_transaction.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class PaymentTran(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    var merchant: Merchant? = null,
    var userId : Long? = null,
    var totalPaid: Double? = null,
    var paymentMethod: String? = null
)
