package com.vs.payment_transaction.controller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.AccountDto
import com.vs.payment_transaction.dto.AccountRequest
import com.vs.payment_transaction.service.AccountService
import com.vs.payment_transaction.utilities.constrants.Constrant
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${ Constrant.MAIN_PATH}/accounts")
class AccountController(
    private val accountService: AccountService
) {
  @GetMapping
  fun getAll() : ObjectResponse<List<AccountDto>>{
      return accountService.findAll()
  }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: Long): ObjectResponse<AccountDto>{
      return accountService.findById(id)
  }

  @PostMapping("/create")
  fun create(@RequestBody req: AccountRequest): MessageResponse{
      return accountService.create(req)
  }

  @PutMapping("/{id}")
  fun update(@PathVariable id: Long, @RequestBody req: AccountRequest): ObjectResponse<AccountDto>{
      return accountService.update(id, req)
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): MessageResponse{
      return accountService.delete(id)
  }
}