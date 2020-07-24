package com.toast.wanandroid.repository

import com.toast.core.base.repository.BaseRepositoryBoth
import com.toast.core.base.repository.ILocalDataSource
import com.toast.core.base.repository.IRemoteDataSource
import com.toast.wanandroid.entity.user.UserInfo
import com.toast.wanandroid.http.Results
import com.toast.wanandroid.http.processApiResponse
import com.toast.wanandroid.http.service.ServiceManager

/**
 * @author toast
 * @date 2020/4/23 13:55
 * @description
 */
class LoginRepository(
    remoteDataSource: LoginRemoteDataSource,
    localDataSource: LoginLocalDataSource
) : BaseRepositoryBoth<LoginRemoteDataSource, LoginLocalDataSource>(remoteDataSource, localDataSource) {

    // 登录
    suspend fun login(username: String, password: String): Results<UserInfo> {
        val userInfo = remoteDataSource.login(username, password)
        when (userInfo) {
            is Results.Failure -> {}
            is Results.Success -> {
                // 保存用户信息到本地
                localDataSource.saveUserInfo(userInfo.data)
            }
        }
        return userInfo
    }

    // 是否登录
    fun hasLogin(): Boolean {
        return localDataSource.hasLogin()
    }

}

class LoginRemoteDataSource(private val serviceManager: ServiceManager): IRemoteDataSource {

    suspend fun login(username:String, password: String): Results<UserInfo> {
        val response = serviceManager.loginService.login(username, password)
        return  processApiResponse(response)
    }

}

class LoginLocalDataSource(
    private val userInfoRepository: UserInfoRepository
): ILocalDataSource {

    /**
     * 根据本地存放的userId判断是否已经登录
     */
    fun hasLogin(): Boolean {
        return userInfoRepository.hasLogin()
    }

    fun saveUserInfo(userInfo: UserInfo) {
        userInfoRepository.apply {
            username = userInfo.username
            userId = userInfo.id
            this.userInfo = userInfo
        }
    }
}