package com.vs.payment_transaction.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "temp_count")
@IdClass(TempCountId::class)
data class TempCount(
   @Id
   var userId: Long? = 0,
   @Id
   var merchantId: Long?= 0,
   var paymentCount: Long? = 0,
   var totalPaid: Double? = 0.0
)

data class TempCountId(
    var userId: Long? = 0,
    var merchantId: Long? = 0
) : Serializable
