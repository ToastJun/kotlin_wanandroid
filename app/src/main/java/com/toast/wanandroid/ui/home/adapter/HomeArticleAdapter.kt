package com.toast.wanandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.toast.wanandroid.R
import com.toast.wanandroid.entity.ArticleInfo
import kotlinx.android.synthetic.main.item_rv_article.view.*

/**
 * @author toast
 * @date 2020/4/30 11:01
 * @description
 */
class HomeArticleAdapter(
    itemCallback: DiffCallback = DiffCallback()
): ListAdapter<ArticleInfo, HomeArticleAdapter.ViewHolder>(itemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_article, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int, data: ArticleInfo) {
            itemView.tvTitle.text = data.title
            itemView.tvDesc.text = data.desc
            // 没有作者则显示分享者
            itemView.tvAuthor.text = if(data.author.isNotEmpty()) "by ${data.author}"  else "share by ${data.shareUser}"
            itemView.tvNiceDate.text = data.niceDate
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ArticleInfo>() {
        override fun areItemsTheSame(oldItem: ArticleInfo, newItem: ArticleInfo): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ArticleInfo, newItem: ArticleInfo): Boolean = oldItem == newItem

    }
}