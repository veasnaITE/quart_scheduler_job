package com.vs.payment_transaction.base.response

import org.springframework.stereotype.Component

@Component
class ResponseMessage(
    var code : Int ?= 200,
    var message: String ?= "Success",
    var title: String? = "Transaction Managementd"
) {
    fun success(): ResponseMessage = ResponseMessage()
    fun error(): ResponseMessage = ResponseMessage(
        500,
        "Please Check on Error Details",
        "Internal Server Error"
    )
}