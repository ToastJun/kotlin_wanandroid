package com.toast.wanandroid.ui.mine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.toast.core.base.viewmodel.BaseViewModel
import com.toast.core.ext.postNext
import com.toast.wanandroid.http.Results
import kotlinx.coroutines.launch

/**
 * @author toast
 * @date 2020/7/20 16:03
 * @description
 */
class MineViewModel(
    private val mineRepository: MineRepository
): BaseViewModel() {

    private val _stateLiveData: MutableLiveData<MineViewState> = MutableLiveData(MineViewState.initial())

    val stateLiveData = _stateLiveData

    fun getUserInfo() {
        val localUserInfo = mineRepository.getLocalUserInfo()
        // 先直接从本地获取，后面再增加获取最新个人数据并更新本地数据
        _stateLiveData.postNext {
            it.copy(isLoading = false, userInfo = localUserInfo)
        }
    }

    /**
     * 获取用户积分
     */
    fun fetchUserCoin() {
        viewModelScope.launch {
            when (val result = mineRepository.fetchUserCoin()) {
                is Results.Failure -> _stateLiveData.postNext {
                    it.copy(isLoading = false, userInfo = null, userCoin = null, error = result.error)
                }
                is Results.Success -> _stateLiveData.postNext {
                    it.copy(isLoading = false, userCoin = result.data, userInfo = null, error = null)
                }
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class MineViewModelFactory(private val mineRepository: MineRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MineViewModel(mineRepository) as T
    }
}