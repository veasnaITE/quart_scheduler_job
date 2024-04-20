package com.vs.payment_transaction.base.response

import org.springframework.stereotype.Component

@Component
class MessageResponse(
    var responseMessage: ResponseMessage? = ResponseMessage().success()
)