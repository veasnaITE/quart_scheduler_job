package com.vs.payment_transaction.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    var firstName: String? = null,
    var lastName: String? = null,
    var address: String? = null
)
