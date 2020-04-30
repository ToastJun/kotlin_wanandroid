package com.toast.wanandroid.entity

/**
 * @author toast
 * @date 2020/4/26 16:38
 * @description 文章信息
 */

data class ArticleInfoList(
    var curPage: Int,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int,
    var datas: MutableList<ArticleInfo>
)

data class ArticleInfo(
    var id: Int,
    var apkLink: String,
    var audit: Int,
    var author: String,
    var canEdit: Boolean,
    var chapterId: Int,
    var chapterName: String,
    var collect: Boolean,
    var courseId: Int,
    var desc: String,
    var descMd: String,
    var envelopPic: String,
    var fresh: Boolean,
    var link: String,
    var niceDate: String,
    var niceShareDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var selfVisible: Int,
    var shareDate: Long,
    var shareUser: String,
    var superChapterId: Int,
    var superChapterName: String,
    var tags: List<ArticleTag>,
    var title: String,
    var type: Int,
    var userId: Int,
    var visible: Int,
    var zan: Int
)

data class ArticleTag(
    var name: String,
    var url: String
)