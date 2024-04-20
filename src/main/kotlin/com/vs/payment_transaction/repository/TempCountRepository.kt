package com.vs.payment_transaction.repository

import com.vs.payment_transaction.model.TempCount
import com.vs.payment_transaction.model.TempCountId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TempCountRepository : JpaRepository<TempCount, TempCountId> {

}