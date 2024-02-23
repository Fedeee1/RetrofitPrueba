package com.example.retrofitprueba.data.domain.repository.remote.response

import com.example.retrofitprueba.data.domain.model.error.ErrorModel

sealed class BaseResponse<T> {
    class Success<T>(val data: T) : BaseResponse<T>()
    class Error<T>(val error: ErrorModel) : BaseResponse<T>()
}