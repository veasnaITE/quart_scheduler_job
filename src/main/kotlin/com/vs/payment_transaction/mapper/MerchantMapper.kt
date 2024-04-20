package com.vs.payment_transaction.mapper

import com.vs.payment_transaction.dto.MerchantDto
import com.vs.payment_transaction.model.Merchant
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MerchantMapper {
    fun toDto(req: Merchant): MerchantDto
    fun toModel(req: MerchantDto): Merchant
}