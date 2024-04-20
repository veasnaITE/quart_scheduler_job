package com.vs.payment_transaction.model

import jakarta.persistence.*
import java.math.BigDecimal
@Entity
@Table
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null,
    var name: String? = null,
    var amount: BigDecimal? = null
)
