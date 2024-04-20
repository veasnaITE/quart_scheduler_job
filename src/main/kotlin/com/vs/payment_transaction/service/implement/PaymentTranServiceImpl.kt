package com.vs.payment_transaction.service.implement

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.TempCountDto
import com.vs.payment_transaction.dto.PaymentTranDto
import com.vs.payment_transaction.dto.PaymentTranRequest
import com.vs.payment_transaction.mapper.PaymentTranMapper
import com.vs.payment_transaction.repository.PaymentTranRepository
import com.vs.payment_transaction.repository.UserRepository
import com.vs.payment_transaction.service.PaymentTranService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class PaymentTranServiceImpl(
    private val paymentTranRepository: PaymentTranRepository,
    private val paymentTranMapper: PaymentTranMapper,
    private val userRepository: UserRepository
): PaymentTranService {
    override fun create(req: PaymentTranRequest): MessageResponse {
         val paymentTran = paymentTranMapper.toPaymentTran(req)
         paymentTranRepository.save(paymentTran)
         return MessageResponse()
    }

    override fun findAll(): ObjectResponse<List<PaymentTranDto>> {
       val paymentTrans = paymentTranRepository.findAll()
        return ObjectResponse(paymentTranMapper.toListDto(paymentTrans))
    }

    override fun findById(id: Long): ObjectResponse<PaymentTranDto> {
       if (paymentTranRepository.existsById(id)){
           val  payment = paymentTranRepository.findById(id).get()
           return ObjectResponse(paymentTranMapper.toPaymentDto(payment))
       }
        throw ResponseStatusException(HttpStatus.NOT_FOUND,"The paymentTran doesn't exits")
    }

    override fun delete(id: Long): MessageResponse {
       if(paymentTranRepository.existsById(id)){
           paymentTranRepository.deleteById(id)
           return MessageResponse()
       }else throw ResponseStatusException(HttpStatus.NOT_FOUND,"The paymentTran doesn't exits")
    }

    override fun countList(): List<TempCountDto> {
        val users = paymentTranRepository.countUserIdGroupByMerchant()
        println(users)
        return emptyList()
    }
}