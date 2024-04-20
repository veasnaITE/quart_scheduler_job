package com.vs.payment_transaction.mapper

import com.vs.payment_transaction.dto.PaymentTranDto
import com.vs.payment_transaction.dto.PaymentTranRequest
import com.vs.payment_transaction.model.PaymentTran
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface PaymentTranMapper {
    fun toPaymentDto(req: PaymentTran): PaymentTranDto
    fun toListDto(req: List<PaymentTran>): List<PaymentTranDto>
    @Mapping(source = "merchantId",target = "merchant.id")
    fun toPaymentTran(req: PaymentTranRequest): PaymentTran
}