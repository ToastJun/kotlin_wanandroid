package com.toast.core.base.view

import androidx.fragment.app.Fragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.kcontext

/**
 * @author toast
 * @date 2020/4/22 17:46
 * @description
 */
abstract class InjectionFragment: Fragment(), KodeinAware, IView {

    protected val parentKodein by closestKodein()

    override val kodeinContext = kcontext<Fragment>(this)

}