package com.vs.payment_transaction.model

import jakarta.persistence.*

@Entity
@Table
data class Merchant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    var name: String? = null,
    var description: String? = null
)
