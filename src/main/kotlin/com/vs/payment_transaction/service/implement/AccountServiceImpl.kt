package com.vs.payment_transaction.service.implement
import com.vs.payment_transaction.base.response.MessageResponse
import com.vs.payment_transaction.base.response.ObjectResponse
import com.vs.payment_transaction.dto.AccountDto
import com.vs.payment_transaction.dto.AccountRequest
import com.vs.payment_transaction.mapper.AccountMapper
import com.vs.payment_transaction.repository.AccountRepository
import com.vs.payment_transaction.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) : AccountService {
    override fun create(req: AccountRequest): MessageResponse {
        val account = accountMapper.toAccModel(req)
        accountRepository.save(account)
        return MessageResponse()
    }

    override fun findAll(): ObjectResponse<List<AccountDto>> {
        val accounts = accountMapper.toListAccDto(accountRepository.findAll())
        return ObjectResponse(accounts)
    }

    override fun update(id: Long, req: AccountRequest): ObjectResponse<AccountDto> {
       if (accountRepository.existsById(id)){
           var account = accountMapper.toAccModel(req)
           account.id=id
           account= accountRepository.save(account)
           return ObjectResponse(accountMapper.toAccountDto(account))
       }
       throw ResponseStatusException(HttpStatus.NOT_FOUND,"Account doesn't exist.")
    }

    override fun delete(id: Long): MessageResponse {
        if (accountRepository.existsById(id)){
            accountRepository.deleteById(id)
            return MessageResponse()
        }else throw ResponseStatusException(HttpStatus.NOT_FOUND,"Account doesn't exist.")
    }

    override fun findById(id: Long): ObjectResponse<AccountDto> {
        if (accountRepository.existsById(id)){
            val account = accountRepository.findById(id).get()
            return ObjectResponse(accountMapper.toAccountDto(account))
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND,"Account doesn't exist.")
    }

}