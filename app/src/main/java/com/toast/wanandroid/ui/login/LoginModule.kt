package com.toast.wanandroid.ui.login

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.toast.wanandroid.http.service.ServiceManager
import com.toast.wanandroid.repository.LoginLocalDataSource
import com.toast.wanandroid.repository.LoginRemoteDataSource
import com.toast.wanandroid.repository.LoginRepository
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.*

/**
 * @author toast
 * @date 2020/4/26 9:29
 * @description
 */

private const val LOGIN_MODULE_TAG = "login_module_tag"

val kodeinLoginModule = Kodein.Module(LOGIN_MODULE_TAG) {

    bind<LoginViewModel>() with scoped<AppCompatActivity>(AndroidLifecycleScope).singleton {
        ViewModelProvider(this.context, LoginViewModelFactory(instance())).get(LoginViewModel::class.java)
    }
    // LoginRepository 初始化
    bind<LoginRepository>() with singleton {
        LoginRepository(instance(), instance())
    }

    bind<LoginRemoteDataSource>() with singleton {
        LoginRemoteDataSource(instance())
    }

    bind<LoginLocalDataSource>() with singleton {
        LoginLocalDataSource(instance())
    }
}