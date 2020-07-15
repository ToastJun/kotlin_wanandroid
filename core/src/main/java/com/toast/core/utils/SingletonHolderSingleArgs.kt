package com.toast.core.utils

/**
 * @author toast
 * @date 2020/7/15 14:53
 * @description
 */
open class SingletonHolderSingleArgs<out T, in A>(private val creator: (A) -> T) {

    @Volatile
    private var sInstance: T? = null

    fun getInstance(args: A): T {
        return sInstance ?: synchronized(this) {
            sInstance ?: creator(args).apply {
                sInstance = this
            }
        }
    }
}