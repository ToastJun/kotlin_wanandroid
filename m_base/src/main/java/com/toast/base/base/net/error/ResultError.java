package com.toast.base.base.net.error;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toast.base.base.net.error.base.BaseNetError;
import com.toast.base.base.net.http.request.BaseRequest;

/**
 * desc: <br/>
 * time: 2020/11/17 19:26 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class ResultError extends BaseNetError {

    public ResultError(@NonNull Throwable throwable) {
        super(throwable);
    }

    @NonNull
    @Override
    public String key() {
        return "ResultError";
    }

    @Nullable
    @Override
    public String getCustomMessage() {
        return "通信有问题，如：无网络、服务器连接不上等";
    }

    @Override
    public void onError(@NonNull BaseRequest<?> request) {
        super.onError(request);
    }
}
