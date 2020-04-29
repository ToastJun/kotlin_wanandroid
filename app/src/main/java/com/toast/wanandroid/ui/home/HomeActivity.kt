package com.toast.wanandroid.ui.home

import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.toast.core.base.view.BaseActivity
import com.toast.core.base.view.BaseFragment
import com.toast.wanandroid.R
import com.toast.wanandroid.ui.mine.MineFragment
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.Kodein

/**
 * @author toast
 * @date 2020/4/28 15:43
 * @description
 */

class HomeActivity : BaseActivity() {

    override val layoutId: Int = R.layout.activity_home

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)

    }

    private val tabFragments: Map<Int, BaseFragment> = mapOf(
        R.id.action_home to HomeFragment(),
        R.id.action_mine to MineFragment()
    )


    override fun initView() {

        Log.e("init", tabFragments.toString())
        // 默认添加首页
        selectTab(R.id.action_home)

        bottomNav.setOnNavigationItemSelectedListener {
            selectTab(it.itemId)
            true
        }

    }

    /**
     * 切换底部导航栏按钮
     */
    private fun selectTab(itemId: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        tabFragments.map {(key, fragment) ->
            if(fragment.isVisible) {
                beginTransaction.hide(fragment)
            }
        }
        tabFragments[itemId]?.let {
            if (it.isAdded && !it.isVisible) {
                beginTransaction.show(it)
            } else {
                beginTransaction.add(R.id.flContent, it, itemId.toString())
            }
        }
        beginTransaction.commit()
    }

}