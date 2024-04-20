package com.vs.payment_transaction.base.response

class ErrorResponse <T> (
    var responseMessage : ResponseMessage? = ResponseMessage().error(),
    var error: T? = null
)