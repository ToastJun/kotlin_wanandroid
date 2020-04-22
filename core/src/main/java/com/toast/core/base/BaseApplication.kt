package com.toast.core.base

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

/**
 * @author toast
 * @date 2020/4/22 16:41
 * @description
 */
open class BaseApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {  }

}