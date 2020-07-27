package com.toast.wanandroid.ui.mine

import com.toast.core.base.repository.BaseRepositoryBoth
import com.toast.core.base.repository.ILocalDataSource
import com.toast.core.base.repository.IRemoteDataSource
import com.toast.wanandroid.entity.coin.CoinBean
import com.toast.wanandroid.entity.user.UserInfo
import com.toast.wanandroid.http.Results
import com.toast.wanandroid.http.processApiResponse
import com.toast.wanandroid.http.service.ServiceManager
import com.toast.wanandroid.repository.UserInfoRepository

/**
 * @author toast
 * @date 2020/7/20 11:51
 * @description
 */
class MineRepository(
    private val mineRemoteRepository: MineRemoteRepository,
    private val mineLocalRepository: MineLocalRepository
) : BaseRepositoryBoth<MineRemoteRepository, MineLocalRepository>
    (mineRemoteRepository, mineLocalRepository) {

    fun getLocalUserInfo(): UserInfo {
        // 先直接从本地获取
        return mineLocalRepository.getUserInfo()
    }

    suspend fun fetchUserCoin(): Results<CoinBean> {
        return mineRemoteRepository.fetchUserCoin()
    }
}


class MineRemoteRepository(private val serviceManager: ServiceManager): IRemoteDataSource {

    /**
     * 获取用户积分
     */
    suspend fun fetchUserCoin(): Results<CoinBean> {
        val response = serviceManager.userService.fetchUserCoin()
        return processApiResponse(response)
    }
}

class MineLocalRepository(
    private val userInfoRepository: UserInfoRepository
) : ILocalDataSource {

    /**
     * 获取本地存储的用户信息
     */
    fun getUserInfo(): UserInfo {
        return userInfoRepository.userInfo
    }
}