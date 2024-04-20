package com.vs.payment_transaction.controller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.PaymentTranDto
import com.vs.payment_transaction.dto.PaymentTranRequest
import com.vs.payment_transaction.repository.PaymentTranRepository
import com.vs.payment_transaction.service.PaymentTranService
import com.vs.payment_transaction.utilities.constrants.Constrant
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constrant.MAIN_PATH}/payments")
class PaymentTranController(
    private val paymentTranService: PaymentTranService
) {
    @GetMapping("/count")
    fun count():ResponseEntity<String>{
        paymentTranService.countList()
        return ResponseEntity.ok("Done")
    }

    @GetMapping
    fun findAll(): ObjectResponse<List<PaymentTranDto>> {
        return paymentTranService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ObjectResponse<PaymentTranDto> {
        return paymentTranService.findById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody req: PaymentTranRequest): MessageResponse{
        return paymentTranService.create(req)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): MessageResponse{
        return paymentTranService.delete(id)
    }
}