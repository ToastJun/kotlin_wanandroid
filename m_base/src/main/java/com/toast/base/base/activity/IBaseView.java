package com.toast.base.base.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * desc:  View通用接口(Activity、Fragment、FragmentDialog)  <br/>
 * time: 18:20 <br/>
 * author: Toast <br/>
 * since: V1.0 <br/>
 */
public interface IBaseView<TParams> {

    /**
     * Activity 或 Fragment 的super.onCreate() 之前执行
     * @param savedInstanceState
     */
    void onCreateFirstCall(@Nullable Bundle savedInstanceState);

    /**
     * 初始化相关数据
     *
     * @param savedInstanceState
     */
    void initData(@NonNull Bundle savedInstanceState);

    /**
     * 初始化相关变量
     *
     * @param savedInstanceState
     */
    void initVariable(@NonNull Bundle savedInstanceState);

    /**
     * 初始化View
     *
     * @param savedInstanceState
     */
    void initView(@NonNull Bundle savedInstanceState);

    /**
     * 显示标题栏头部信息
     *
     * @param savedInstanceState
     */
    void showTitleBar(@NonNull Bundle savedInstanceState);

    /**
     * 初始化View监听器
     *
     * @param savedInstanceState
     */
    void initListener(@NonNull Bundle savedInstanceState);

    /**
     * 初始化适配器
     *
     * @param savedInstanceState
     */
    void initAdapter(@NonNull Bundle savedInstanceState);

    /**
     * 在有网络情况下，请求或处理数据
     *
     * @param savedInstanceState
     */
    void bindData(@NonNull Bundle savedInstanceState);

    /**
     * 在无网络情况下，处理数据
     *
     * @param savedInstanceState
     */
    void bindData4NoNet(@NonNull Bundle savedInstanceState);

    /**
     * 获取资源布局id
     *
     * @return 布局资源id
     */
    int getContentViewResId();

    /**
     * View 点击事件派发
     *
     * @param view
     */
    void onViewClick(View view);

    /**
     * 获取View 唯一id (每次页面被new新的实例都会变化，但是在当前实例中，不会再变化)
     *
     * @return 唯一id字符串
     */
    String getViewUniqueId();

    /**
     * 当前页面唯一 View Code (值固定，一直不会变化)
     *
     * @return View Code
     */
    int getViewCode();

    /**
     * 获取类名标识 (值固定，一直不会变化)
     *
     * @return  类名标识
     */
    String getTagClassName();

    /**
     * 获取屏幕名称 (主要用于数据跟踪)
     *
     * @return 屏幕名称
     */
    String getScreenName();

    /**
     * 获取View句柄
     */
    <T extends View>T findView(@IdRes int resId);

    /**
     * 获取上个页面传递过来的参数
     */
    @NonNull
    TParams getViewParams();


}
