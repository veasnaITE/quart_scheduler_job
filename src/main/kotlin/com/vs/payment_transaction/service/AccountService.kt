package com.vs.payment_transaction.service

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.AccountDto
import com.vs.payment_transaction.dto.AccountRequest

interface AccountService {
    fun create(req: AccountRequest): MessageResponse
    fun findAll(): ObjectResponse<List<AccountDto>>
    fun update(id: Long, req: AccountRequest): ObjectResponse<AccountDto>
    fun delete(id: Long): MessageResponse
    fun findById(id: Long): ObjectResponse<AccountDto>
}
