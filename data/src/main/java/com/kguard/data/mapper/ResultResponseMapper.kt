package com.kguard.data.mapper

import com.kguard.data.model.dto.ResultResponse
import com.kguard.domain.model.DomainResult

object ResultResponseMapper {
    fun toDomainResult(result: ResultResponse): DomainResult =
        DomainResult(
            code = result.code,
            message = result.message
        )
}