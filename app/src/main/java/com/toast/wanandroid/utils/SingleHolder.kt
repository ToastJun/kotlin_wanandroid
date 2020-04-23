package com.toast.wanandroid.utils

/**
 * @author toast
 * @date 2020/4/23 17:41
 * @description 单例工具类
 * see https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
 */
open class SingleHolder<out T: Any, in A>(private var creator: (A) -> T) {

    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        return instance ?: synchronized(this) {
            return instance ?: creator(arg).apply {
                instance = this
            }
        }
    }
}