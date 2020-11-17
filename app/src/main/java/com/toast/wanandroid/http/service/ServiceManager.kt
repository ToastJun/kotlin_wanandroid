package com.toast.wanandroid.http.service

/**
 * @author toast
 * @date 2020/4/22 18:30
 * @description
 */
data class ServiceManager (val userService: UserService,
                           val loginService: LoginService,
                           val articleService: ArticleService,
                           val thirdApiService: ThridApiService
)