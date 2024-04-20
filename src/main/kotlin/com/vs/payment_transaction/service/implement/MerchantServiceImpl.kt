package com.vs.payment_transaction.service.implement;

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.MerchantDto
import com.vs.payment_transaction.mapper.MerchantMapper
import com.vs.payment_transaction.repository.MerchantRepository
import com.vs.payment_transaction.service.MerchantService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException

@Service
 class MerchantServiceImpl(
    private val merchantRepository: MerchantRepository,
    private val merchantMapper: MerchantMapper
 ): MerchantService {
 override fun create(req: MerchantDto): MessageResponse {
    val merchant = merchantMapper.toModel(req)
    merchantRepository.save(merchant)
    return MessageResponse()
 }

 override fun update(id: Long, req: MerchantDto): ObjectResponse<MerchantDto> {
    if (merchantRepository.existsById(id)){
       val merchant = merchantMapper.toModel(req)
       merchant.id = id
       return ObjectResponse(merchantMapper.toDto(merchantRepository.save(merchant)))
    }
    throw ResponseStatusException(HttpStatus.NOT_FOUND,"Merchant was not found")
 }

 override fun delete(id: Long): MessageResponse {
    if (merchantRepository.existsById(id)){
      merchantRepository.deleteById(id)
      return MessageResponse()
    }else  throw ResponseStatusException(HttpStatus.NOT_FOUND,"Merchant was not found")
 }

 override fun findById(id: Long): ObjectResponse<MerchantDto> {
    if (merchantRepository.existsById(id)){
      val merchant = merchantMapper.toDto(merchantRepository.findById(id).get())
     return ObjectResponse(merchant)
    }
     throw ResponseStatusException(HttpStatus.NOT_FOUND,"Merchant was not found")
 }

 override fun findAll(): ObjectResponse<List<MerchantDto>> {
  val merchants = merchantRepository.findAll()
  return ObjectResponse(merchants.map { merchantMapper.toDto(it) })
 }
}
