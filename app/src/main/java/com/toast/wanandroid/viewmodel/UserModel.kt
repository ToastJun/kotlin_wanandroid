package com.toast.wanandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author toast
 * @date 2020/4/2 11:30
 * @description
 */
class UserModel: ViewModel() {

    val currentUser: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    fun addUser(user: User) {
        currentUser.postValue(user)
    }

    override fun onCleared() {
        super.onCleared()
    }
}