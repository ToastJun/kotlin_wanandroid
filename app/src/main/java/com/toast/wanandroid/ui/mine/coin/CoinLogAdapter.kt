package com.toast.wanandroid.ui.mine.coin

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.toast.wanandroid.R
import com.toast.wanandroid.entity.coin.CoinLogBean

/**
 * @author toast
 * @date 2020/7/24 16:06
 * @description
 */
class CoinLogAdapter(layoutResId: Int = R.layout.item_rv_coin_log, data: MutableList<CoinLogBean>?) :
    BaseQuickAdapter<CoinLogBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: CoinLogBean) {

    }

}