package com.vs.payment_transaction.mapper

import com.vs.payment_transaction.dto.TempCountDto
import com.vs.payment_transaction.model.TempCount
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TempCountMapper {
    fun toTempCount(req: TempCountDto): TempCount
}