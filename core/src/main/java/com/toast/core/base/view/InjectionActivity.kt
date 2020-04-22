package com.toast.core.base.view

import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.kcontext

/**
 * @author toast
 * @date 2020/4/22 16:51
 * @description
 */
abstract class InjectionActivity: AppCompatActivity(), KodeinAware, IView {
    // closestKodein() 函数返回了相邻上层的一个 Kodein 容器，对于Activity来说，返回的是Application层级的Kodein容器
    private val parentKodein by closestKodein()

    override val kodeinContext = kcontext<AppCompatActivity>(this)

    // 创建一个不受Activity重启影响的 kodein 对象
    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)
    }
}