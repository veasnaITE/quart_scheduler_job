package com.vs.payment_transaction.service

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.UserDto
import com.vs.payment_transaction.dto.UserRequest
interface UserService {
    fun create(req:UserRequest) : MessageResponse
    fun update(id: Long, req: UserRequest) : ObjectResponse<UserDto>
    fun delete(id: Long): MessageResponse
    fun findAll(): ObjectResponse<List<UserDto>>
    fun findById(id: Long) : ObjectResponse<UserDto>
}