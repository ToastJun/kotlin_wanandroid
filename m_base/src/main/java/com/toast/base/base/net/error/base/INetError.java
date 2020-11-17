package com.toast.base.base.net.error.base;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

import com.toast.base.base.net.http.request.BaseRequest;

/**
 * desc: 自定义错误 <br/>
 * time: 2020/11/17 19:26 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
interface INetError {

    /**
     * 错误key值
     */
    @NonNull
    String key();

    /**
     * 发生错误，注意：该函数后台线程调用
     *
     * @param request 发生错误的请求
     */
    @WorkerThread
    void onError(@NonNull BaseRequest<?> request);
}
