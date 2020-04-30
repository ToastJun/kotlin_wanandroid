package com.toast.wanandroid.ui.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.toast.core.base.view.BaseFragment
import com.toast.core.ext.observe
import com.toast.core.ext.toastSafe
import com.toast.wanandroid.R
import com.toast.wanandroid.entity.ArticleInfo
import com.toast.wanandroid.ui.home.adapter.HomeArticleAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author toast
 * @date 2020/4/29 9:50
 * @description
 */
class HomeFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_home

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        import(kodeinHomeModule)
    }

    val mHomeViewModule: HomeViewModel by instance()

    private lateinit var homeArticleAdapter: HomeArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        initRefresh()

        initData()
    }

    private fun initView() {
        homeArticleAdapter = HomeArticleAdapter()
        recyclerView.adapter = homeArticleAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initData() {
        binds()

        refreshLayout.autoRefresh()
    }

    private fun binds() {
        observe(mHomeViewModule.stateLiveData) {
            if (it.error != null) {
                requireContext().toastSafe(it.error.toString())
            } else {
                var newList = ArrayList(homeArticleAdapter.currentList)
                if (it.page != 1) {
                    newList.addAll(it.articleInfoList?.datas ?: emptyList())
                    homeArticleAdapter.submitList(newList)
                } else {
                    homeArticleAdapter.submitList(it.articleInfoList?.datas)
                }

            }
            refreshLayout.run {
                finishLoadMore()
                finishRefresh()
            }
        }
    }

    private fun initRefresh() {
        refreshLayout.apply {
            setOnRefreshLoadMoreListener(object: OnRefreshLoadMoreListener {
                override fun onLoadMore(refreshLayout: RefreshLayout) {
                    mHomeViewModule.fetchArticleList(mHomeViewModule.stateLiveData.value!!.page + 1)
                }

                override fun onRefresh(refreshLayout: RefreshLayout) {
                    mHomeViewModule.fetchArticleList(1)
                }
            })

        }
    }
}