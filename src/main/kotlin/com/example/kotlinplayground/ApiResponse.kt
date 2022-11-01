package com.example.kotlinplayground


class ApiResponse<T>(
    val message: String,
    val data : T? = null) {

    companion object {
        fun ok(): ApiResponse<Any>{
            return ApiResponse(message = "성공", data = "")
        }

        fun <T>ok(data : T) : ApiResponse<T>{
            return ApiResponse("ok", data)
        }
        
        fun error(message: String) : ApiResponse<Any> {
            return ApiResponse(message)
        }

        fun none_auth() : ApiResponse<Any> {
            return ApiResponse("권한이 없습니다", "")
        }
    }




}
