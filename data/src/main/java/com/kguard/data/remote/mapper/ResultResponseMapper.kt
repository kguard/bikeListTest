package com.kguard.data.remote.mapper

import com.kguard.data.remote.dto.ResultResponse
import com.kguard.domain.model.DomainResult

object ResultResponseMapper {
    fun toDomainResult(result: ResultResponse): DomainResult =
        DomainResult(
            code = result.code,
            message = result.message
        )
}