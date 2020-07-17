package com.toast.wanandroid.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toast.core.base.viewmodel.BaseViewModel
import com.toast.core.ext.postNext
import com.toast.wanandroid.repository.UserInfoRepository

/**
 * @author toast
 * @date 2020/7/16 11:00
 * @description
 */
class MainViewModel(
    private val userInfoRepository: UserInfoRepository
) : BaseViewModel(){

    private val _stateLiveData : MutableLiveData<MainViewState> = MutableLiveData(MainViewState.initial())

    val stateLiveData: LiveData<MainViewState> = _stateLiveData

    /**
     * 判断本地是否存有token
     */
    fun checkIsLogin() {
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