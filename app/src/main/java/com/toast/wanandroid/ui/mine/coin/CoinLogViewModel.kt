package com.toast.wanandroid.ui.mine.coin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toast.core.base.viewmodel.BaseViewModel

/**
 * @author toast
 * @date 2020/7/24 15:07
 * @description
 */
class CoinLogViewModel : BaseViewModel() {

    private val _stateLiveData = MutableLiveData<CoinLogViewState>(CoinLogViewState.initial())
    var stateLiveData = _stateLiveData



}

class CoinLogViewModelFactory(): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoinLogViewModel() as T
    }
}