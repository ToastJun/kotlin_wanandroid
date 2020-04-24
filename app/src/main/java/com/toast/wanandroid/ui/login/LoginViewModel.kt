package com.toast.wanandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.toast.core.base.viewmodel.BaseViewModel

/**
 * @author toast
 * @date 2020/4/24 16:29
 * @description
 */

class LoginViewModel() : BaseViewModel() {

    // liveData
    private val _stateLiveData = MutableLiveData<LoginViewState>()

    val stateLive: LiveData<LoginViewState> = _stateLiveData

    init {

    }
}