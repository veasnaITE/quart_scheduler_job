package com.vs.payment_transaction.repository

import com.vs.payment_transaction.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long>{

}
