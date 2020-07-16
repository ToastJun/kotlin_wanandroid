package com.toast.wanandroid.ui.login

import androidx.lifecycle.*
import com.orhanobut.logger.Logger
import com.toast.core.base.viewmodel.BaseViewModel
import com.toast.core.ext.postNext
import com.toast.wanandroid.http.Errors
import com.toast.wanandroid.http.Results
import com.toast.wanandroid.repository.LoginRepository
import kotlinx.coroutines.launch

/**
 * @author toast
 * @date 2020/4/24 16:29
 * @description
 */

class LoginViewModel(
    private val loginRepo: LoginRepository
) : BaseViewModel() {

    // liveData
    private val _stateLiveData = MutableLiveData<LoginViewState>(LoginViewState.initial())

    val stateLive: LiveData<LoginViewState> = _stateLiveData

    init {
        viewModelScope.launch {

        }
    }

    fun login(username: String?, password: String?) {
        // 判断用户输入的用户名或密码是否为空
        when (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            true -> {
                _stateLiveData.postNext { state ->
                    state.copy(isLoading = false, userInfo = null, throwable = Errors.EmptyInputError("username or password is empty"))
                }
            }
            false -> {
                // 开始请求服务器进行登录
                viewModelScope.launch {
                    Logger.e("start login")
                    val userInfoResult = loginRepo.login(username, password)
                    Logger.e("login end result=$userInfoResult")
                    when (userInfoResult) {
                        is Results.Success -> _stateLiveData.postNext {
                            it.copy(isLoading = false, userInfo = userInfoResult.data, throwable = null)
                        }
                        is Results.Failure -> _stateLiveData.postNext {
                            it.copy(isLoading = false, userInfo = null, throwable = userInfoResult.error)
                        }
                    }
                }
            }
        }
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