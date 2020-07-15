package com.toast.wanandroid.ui.login

import com.toast.core.base.view.BaseActivity
import com.toast.core.ext.observe
import com.toast.wanandroid.R
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
            mViewModel.login()
        }

        observe(mViewModel.stateLive, this::onNewState)
    }

    private fun onNewState(state: LoginViewState) {
        // 根据错误信息进行提示
        if (state.throwable != null) {

        }

    }
}