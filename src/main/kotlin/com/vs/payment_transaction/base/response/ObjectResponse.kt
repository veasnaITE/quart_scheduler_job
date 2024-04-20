package com.vs.payment_transaction.base.response

import org.springframework.stereotype.Component

@Component
class ObjectResponse <T> (
    var results: T? = null,
    var responseMessage: ResponseMessage? = ResponseMessage().success()
)