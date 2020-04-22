package com.toast.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author toast
 * @date 2020/4/22 17:49
 * @description
 */
abstract class BaseFragment: InjectionFragment() {

    private var mRootView: View? = null

    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(layoutId, container, false)
        return mRootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mRootView = null
    }
}