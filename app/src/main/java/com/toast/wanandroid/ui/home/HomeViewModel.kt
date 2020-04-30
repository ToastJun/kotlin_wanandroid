package com.toast.wanandroid.ui.home

import android.util.Log
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
 * @date 2020/4/30 9:45
 * @description
 */
class HomeViewModel(
    private val repository: HomeRepository
): BaseViewModel() {

    private val _stateLiveData: MutableLiveData<HomeViewState> = MutableLiveData(HomeViewState.initial())

    val stateLiveData = _stateLiveData

    fun fetchArticleList(page: Int = 1) {
        viewModelScope.launch {
            when (val result = repository.fetchRemoteArticleList(page)) {
                is Results.Success -> _stateLiveData.postNext {
                    Log.e("fetch", result.toString())
                    it.copy(isLoading = false, error = null, page = page, articleInfoList = result.data)
                }
                is Results.Failure -> _stateLiveData.postNext {
                    Log.e("fetch", result.toString())
                    it.copy(isLoading = false, error = result.error)
                }
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class HomeViewModuleFactory(
    private val repository: HomeRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}