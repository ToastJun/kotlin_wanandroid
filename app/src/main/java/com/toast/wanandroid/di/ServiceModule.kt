package com.toast.wanandroid.di

import com.toast.wanandroid.http.service.LoginService
import com.toast.wanandroid.http.service.ServiceManager
import com.toast.wanandroid.http.service.UserService
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

/**
 * @author toast
 * @date 2020/4/26 10:35
 * @description Api 请求的Module
 */
private const val SERVICE_MODULE_TAG = "service_module_tag"

val serviceModule = Kodein.Module(SERVICE_MODULE_TAG) {

    // ServiceManager 使用单例
    bind<ServiceManager>() with singleton {
        ServiceManager(instance(), instance())
    }

    bind<LoginService>() with singleton {
        instance<Retrofit>().create(LoginService::class.java)
    }

    bind<UserService>() with singleton {
        instance<Retrofit>().create(UserService::class.java)
    }
}