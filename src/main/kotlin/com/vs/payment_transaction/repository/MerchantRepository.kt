package com.vs.payment_transaction.repository

import com.vs.payment_transaction.model.Merchant
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository:JpaRepository<Merchant,Long> {
}