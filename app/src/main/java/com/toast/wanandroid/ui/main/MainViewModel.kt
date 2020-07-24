package com.toast.wanandroid.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.toast.core.base.viewmodel.BaseViewModel
import com.toast.core.ext.postNext
import com.toast.wanandroid.repository.UserInfoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author toast
 * @date 2020/7/16 11:00
 * @description
 */
class MainViewModel(
    private val userInfoRepository: UserInfoRepository
) : BaseViewModel(){

    init {
        Log.e("test", "MainViewModel init")
        viewModelScope.launch {
            // 进来延迟2000ms
            delay(2000)
            checkIsLogin()
        }
    }

    private val _stateLiveData : MutableLiveData<MainViewState> = MutableLiveData(MainViewState.initial())

    val stateLiveData: LiveData<MainViewState> = _stateLiveData

    /**
     * 判断本地是否存有token
     */
    private fun checkIsLogin() {
        _stateLiveData.postNext {
            it.copy(isFinishInit = true, autoLoginEvent = AutoLoginEvent(userInfoRepository.hasLogin()))
        }
    }
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val userInfoRepository: UserInfoRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(userInfoRepository) as T
    }
}

data class AutoLoginEvent(val hasLogin: Boolean)