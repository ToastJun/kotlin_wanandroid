package com.toast.wanandroid.entity

/**
 * @author toast
 * @date 2020/7/20 18:34
 * @description 列表数据基础类
 */

data class BaseListBean<T>(
    var curPage: Int,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int,
    var datas: MutableList<T>
)