package com.vs.payment_transaction.repository

import com.vs.payment_transaction.model.PaymentTran
import com.vs.payment_transaction.model.TempCount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PaymentTranRepository:JpaRepository<PaymentTran,Long> {
    @Query(
        """
        SELECT NEW com.vs.payment_transaction.model.TempCount(p.userId , p.merchant.id , COUNT(p), SUM(p.totalPaid))
        FROM PaymentTran p
        WHERE p.userId IN (
            SELECT p.userId FROM PaymentTran p GROUP BY p.userId
        )
        GROUP BY p.merchant.id, p.userId
    """
    )
    fun countUserIdGroupByMerchant(): List<TempCount>
}