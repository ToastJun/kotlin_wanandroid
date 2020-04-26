package com.toast.wanandroid.ui.login

import android.util.Log
import androidx.lifecycle.*
import com.orhanobut.logger.Logger
import com.toast.core.base.viewmodel.BaseViewModel
import com.toast.wanandroid.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author toast
 * @date 2020/4/24 16:29
 * @description
 */

class LoginViewModel(
    private val loginRepo: LoginRepository
) : BaseViewModel() {

    // liveData
    private val _stateLiveData = MutableLiveData<LoginViewState>()

    val stateLive: LiveData<LoginViewState> = _stateLiveData

    init {
        viewModelScope.launch {

        }
    }

    fun login() {
        viewModelScope.launch {
            Log.e("Login","loginBackground执行前 Thread name =" + Thread.currentThread().name)
            loginBackground()
            Log.e("Login","loginBackground执行后 Thread name =" + Thread.currentThread().name)
        }
        Log.e("Login","!!!!!!login Thread name =" + Thread.currentThread().name)
    }

    suspend fun loginBackground() {
        delay(1000)
        Log.e("Login","loginBackground Thread name =" + Thread.currentThread().name)

        val list = loginRepo.fetch()
        Log.e("Login","loginBackground Thread name =" + Thread.currentThread().name + " ${list.toString()}")
    }
}

class LoginViewModelFactory(
    private val loginRepo: LoginRepository
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRepo) as T
    }

}