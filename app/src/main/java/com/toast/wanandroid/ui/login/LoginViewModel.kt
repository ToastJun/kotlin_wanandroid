package com.toast.wanandroid.ui.login

import android.util.Log
import androidx.lifecycle.*
import com.orhanobut.logger.Logger
import com.toast.core.base.viewmodel.BaseViewModel
import com.toast.core.ext.postNext
import com.toast.wanandroid.entity.ArticleInfoList
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

    fun login() {
        viewModelScope.launch {
            _stateLiveData.postNext {
                it.copy(isLoading = false, articleInfoList = null)
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