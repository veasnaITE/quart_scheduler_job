package com.vs.payment_transaction.controller

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.UserDto
import com.vs.payment_transaction.dto.UserRequest
import com.vs.payment_transaction.service.UserService
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
@RequestMapping("${Constrant.MAIN_PATH}/users")
class UserController(
    private val userService: UserService
){
   @GetMapping
   fun getAll():ObjectResponse<List<UserDto>> {
       return userService.findAll()
   }
   @PostMapping("/create")
   fun create(@RequestBody req: UserRequest):MessageResponse{
       return userService.create(req)
   }
   @PutMapping("/{id}")
   fun update(@PathVariable id: Long, req: UserRequest): ObjectResponse<UserDto>{
       return userService.update(id, req)
   }
   @DeleteMapping("/{id}")
   fun delete(@PathVariable id: Long) : MessageResponse{
       return userService.delete(id)
   }
    @GetMapping("/{id}")
   fun findById(@PathVariable id: Long) : ObjectResponse<UserDto>{
       return userService.findById(id)
   }
}