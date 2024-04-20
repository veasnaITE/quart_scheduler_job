package com.vs.payment_transaction.service.implement

import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.base.response.ResponseMessage
import com.vs.payment_transaction.dto.UserDto
import com.vs.payment_transaction.dto.UserRequest
import com.vs.payment_transaction.mapper.UserMapper
import com.vs.payment_transaction.repository.UserRepository
import com.vs.payment_transaction.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper : UserMapper
) : UserService {

    override fun create(req: UserRequest): MessageResponse {
        val user = userMapper.toUser(req)
        userRepository.save(user)
        return MessageResponse()
    }

    override fun update(id: Long, req: UserRequest): ObjectResponse<UserDto> {
        if(userRepository.existsById(id)){
            val user = userMapper.toUser(req)
            user.id
            val userDto = userRepository.save(user)
            return ObjectResponse(userMapper.toUserDto(userDto))
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND,"User was not found!!")
    }

    override fun delete(id: Long): MessageResponse {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id)
            return MessageResponse()
        }else throw ResponseStatusException(HttpStatus.NOT_FOUND,"User was not found!!")
    }

    override fun findAll(): ObjectResponse<List<UserDto>> {
        val users = userMapper.toListUserDto(userRepository.findAll())
        return ObjectResponse(users)
    }

    override fun findById(id: Long): ObjectResponse<UserDto> {
       if (userRepository.existsById(id)){
           val user = userMapper.toUserDto(userRepository.findById(id).get())
           return ObjectResponse(user)
       }
       throw ResponseStatusException(HttpStatus.NOT_FOUND,"User was not found!!")
    }
}