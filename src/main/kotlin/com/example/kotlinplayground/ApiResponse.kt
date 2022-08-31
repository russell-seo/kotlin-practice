package com.example.kotlinplayground


class ApiResponse<T>(private val message: String, private val data : T) {

    companion object {
        fun ok(): ApiResponse<Any>{
            return ApiResponse(message = "성공", data = "")
        }
        
        fun error(message: String) : ApiResponse<Any> {
            return ApiResponse(message, 1)
        }

        fun none_auth() : ApiResponse<Any> {
            return ApiResponse("권한이 없습니다", "")
        }
    }




}
