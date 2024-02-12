package com.example.retrofitprueba.data.domain.model.error

import com.example.retrofitprueba.data.domain.model.BaseModel

class ErrorModel(
    var error: String = "unknow",
    var errorCode: String = "",
    var message: String = "unknow"
) : BaseModel()