package com.vs.payment_transaction.base.response

class PageResponse <T> (
    var total: Long? = null,
    var result: T? = null,
    var response: ResponseMessage? = ResponseMessage().success()
)