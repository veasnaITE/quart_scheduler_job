package com.vs.payment_transaction.repository

import com.vs.payment_transaction.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account,Long> {
}