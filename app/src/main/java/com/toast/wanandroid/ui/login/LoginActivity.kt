package com.toast.wanandroid.ui.login

import android.content.Intent
import com.toast.core.base.view.BaseActivity
import com.toast.core.ext.observe
import com.toast.core.ext.toastSafe
import com.toast.wanandroid.R
import com.toast.wanandroid.http.Errors
import com.toast.wanandroid.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

/**
 * @author toast
 * @date 2020/7/15 17:44
 * @description
 */

class LoginActivity : BaseActivity() {
    override val layoutId: Int = R.layout.activity_login

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        import(kodeinLoginModule)
    }

    private val mViewModel: LoginViewModel by instance()

    override fun initView() {
        binds()
    }

    private fun binds() {
        btnLogin.setOnClickListener {
            mViewModel.login(etUsername.text.toString(), etPassword.text.toString())
        }

        observe(mViewModel.stateLive, this::onNewState)
    }

    private fun onNewState(state: LoginViewState) {
        // 根据错误信息进行提示
        if (state.throwable != null) {
            when (state.throwable) {
                is Errors.NetworkError -> {
                    state.throwable.desc
                }
                is Errors.EmptyInputError -> state.throwable.errorMessage
                else -> "Network is error"
            }.also {
                toastSafe(it)
            }
        }

        // 登录成功, 跳转到首页
        if (state.userInfo != null) {
            toastSafe("登录成功!")
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}