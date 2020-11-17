package com.toast.m_base.base.net.error.base;

import android.util.Log;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import com.toast.m_base.base.net.http.request.BaseRequest;

/**
 * desc: <br/>
 * time: 2020/11/17 20:44 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public abstract class BaseNetError extends Throwable implements INetError {

    public BaseNetError(@NonNull Throwable throwable) {
        super(throwable);
    }

    @CallSuper
    @Override
    @WorkerThread
    public void onError(@NonNull BaseRequest<?> request) {
        // TODO: 2020/11/17 TOAST 注意此处需要判断是否为测试环境
        String errorMsg = "key:" + key()
                + ", customMsg:" + getCustomMessage()
                + ", url:" + request.getUrl()
                + ", exMsg:" + getMessage();
        Log.e("HttpConn", errorMsg);
    }

    @Nullable
    public String getCustomMessage() {
        // 子类定制信息
        return null;
    }
}
