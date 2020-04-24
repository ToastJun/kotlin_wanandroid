package com.toast.core.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @author toast
 * @date 2020/4/24 16:49
 * @description
 */

inline fun <reified T> MutableLiveData<T>.postNext(map: (T) -> T) {
    postValue(map(verifyLiveDataNotEmpty()))
}

inline fun <reified T> MutableLiveData<T>.setNext(map: (T) -> T) {
    value = map(verifyLiveDataNotEmpty())
}

/**
 * 判断 LiveData 中的value是否为空
 */
inline fun <reified T> LiveData<T>.verifyLiveDataNotEmpty(): T {
    return value ?: throw NullPointerException("MutableLiveData<${T::class.java}> not contain value")
}