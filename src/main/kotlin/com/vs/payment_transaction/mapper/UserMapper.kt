package com.vs.payment_transaction.mapper

import com.vs.payment_transaction.dto.UserDto
import com.vs.payment_transaction.dto.UserRequest
import com.vs.payment_transaction.model.User
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toUserDto(req: User) : UserDto
    fun toListUserDto(req: List<User>) : List<UserDto>
    fun toUser(req:UserRequest) : User
}