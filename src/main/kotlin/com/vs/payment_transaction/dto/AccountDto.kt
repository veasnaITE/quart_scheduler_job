package com.vs.payment_transaction.dto
import java.math.BigDecimal

data class AccountDto(
    var name: String? = null,
    var amount: BigDecimal? = null,
    var user: UserDto? = null
)
