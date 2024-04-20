package com.vs.payment_transaction.service

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.MerchantDto

interface MerchantService {
    fun create(req: MerchantDto) : MessageResponse
    fun update(id:Long , req: MerchantDto) : ObjectResponse<MerchantDto>
    fun delete(id: Long) : MessageResponse
    fun findById(id: Long): ObjectResponse<MerchantDto>
    fun findAll(): ObjectResponse<List<MerchantDto>>
}