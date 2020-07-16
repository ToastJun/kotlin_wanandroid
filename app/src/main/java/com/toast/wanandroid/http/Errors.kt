package com.toast.wanandroid.http

/**
 * @author toast
 * @date 2020/4/23 10:20
 * @description
 */

sealed class Errors: Throwable() {
    data class NetworkError(val code: Int = -1, val desc: String = ""): Errors()

    data class EmptyInputError(val errorMessage: String) : Errors()

    object EmptyResultsError: Errors()
}

