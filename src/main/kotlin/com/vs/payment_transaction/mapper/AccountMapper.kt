package com.vs.payment_transaction.mapper

import com.vs.payment_transaction.dto.AccountDto
import com.vs.payment_transaction.dto.AccountRequest
import com.vs.payment_transaction.model.Account
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface AccountMapper {
    fun toAccountDto(req: Account): AccountDto
    fun toListAccDto(req: List<Account>): List<AccountDto>
    @Mapping(source = "userId", target = "user.id")
    fun toAccModel(req: AccountRequest): Account
}