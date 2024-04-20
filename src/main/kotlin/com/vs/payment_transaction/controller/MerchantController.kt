package com.vs.payment_transaction.controller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.MerchantDto
import com.vs.payment_transaction.service.MerchantService
import com.vs.payment_transaction.utilities.constrants.Constrant
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${ Constrant.MAIN_PATH}/merchants")
class MerchantController(
    private val merchantService: MerchantService
) {
    @PostMapping("/create")
    fun create(@RequestBody req:MerchantDto): MessageResponse{
        return merchantService.create(req)
    }

    @GetMapping
    fun findAll() : ObjectResponse<List<MerchantDto>>{
        return merchantService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ObjectResponse<MerchantDto>{
        return merchantService.findById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,@RequestBody req: MerchantDto) : ObjectResponse<MerchantDto>{
        return merchantService.update(id, req)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): MessageResponse{
        return merchantService.delete(id)
    }
}