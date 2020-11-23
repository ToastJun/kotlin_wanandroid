package com.toast.base.base.net.error;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toast.base.base.net.error.base.BaseNetError;
import com.toast.base.base.net.http.IApiViewModel;
import com.toast.base.base.net.http.request.BaseRequest;

import retrofit2.Response;

/**
 * desc: <br/>
 * time: 2020/11/23 18:13 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class ResponseCodeError extends BaseNetError {

    @NonNull
    private Response response;

    public ResponseCodeError(@NonNull Response response) {
        super(new IllegalStateException("通信错误! response.code: " + response.code()));
        this.response = response;
    }

    @NonNull
    @Override
    public String key() {
        return "ResponseCodeError";
    }

    @Override
    public void onError(@NonNull BaseRequest<?> request, @Nullable IApiViewModel apiViewModel) {
        super.onError(request, apiViewModel);
        // TODO: 2020/11/23 TOAST 调用callViewAction，可用于弹出提示框显示错误信息
    }
}
