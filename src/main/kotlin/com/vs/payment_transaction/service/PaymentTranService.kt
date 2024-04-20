package com.vs.payment_transaction.service

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.TempCountDto
import com.vs.payment_transaction.dto.PaymentTranDto
import com.vs.payment_transaction.dto.PaymentTranRequest

interface PaymentTranService {
    fun create(req: PaymentTranRequest): MessageResponse
    fun findAll(): ObjectResponse<List<PaymentTranDto>>
    fun findById(id: Long): ObjectResponse<PaymentTranDto>
    fun delete(id: Long): MessageResponse
    fun countList():List<TempCountDto>
}