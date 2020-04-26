package com.toast.wanandroid.repository

import com.toast.core.base.repository.BaseRepositoryBoth
import com.toast.core.base.repository.ILocalDataSource
import com.toast.core.base.repository.IRemoteDataSource
import com.toast.wanandroid.entity.ArticleInfoList
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
    fun login(username: String, password: String): Results<UserInfo> {
        return remoteDataSource.login(username, password)
    }

    suspend fun fetch(): ArticleInfoList? {
        return when (val result = remoteDataSource.fetch()) {
            is Results.Success<ArticleInfoList> -> result.data
            is Results.Failure -> null
        }
    }
}

class LoginRemoteDataSource(private val serviceManager: ServiceManager): IRemoteDataSource {

    fun login(username:String, password: String): Results<UserInfo> {
        val response = serviceManager.loginService.login(username, password)
        return  processApiResponse(response)
    }

    suspend fun fetch(): Results<ArticleInfoList> {
        return processApiResponse(serviceManager.loginService.fetch())
    }
}

class LoginLocalDataSource(): ILocalDataSource {

}