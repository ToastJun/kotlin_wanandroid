package com.toast.base.base.net.transformer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toast.base.base.net.error.ResponseCodeError;
import com.toast.base.base.net.error.ResultError;
import com.toast.base.base.net.error.base.INetError;
import com.toast.base.base.net.http.IApiViewModel;
import com.toast.base.base.net.http.request.BaseRequest;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava2.Result;

/**
 * desc: <br/>
 * time: 2020/11/23 18:00 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
abstract class TransformerBase<Upstream, Downstream> implements ObservableTransformer<Upstream, Downstream> {

    @NonNull
    ObservableSource<? extends Result<ResponseBody>> handleResultErrors(Result<ResponseBody> result) {
        if (result.isError()) {
            // 异常、网络问题、socket error 等
            return Observable.error(new ResultError(result.error()));
        } else if ((result.response() != null) && (!result.response().isSuccessful())) {
            // 404/500等
            return Observable.error(new ResponseCodeError(result.response()));
        }

        return Observable.just(result);
    }

    /**
     * 处理网络请求过程中，捕获的自定义错误
     */
    void handleErrors(@NonNull BaseRequest<?> request, @Nullable IApiViewModel apiViewModel, @Nullable Throwable throwable) {
        if (throwable instanceof INetError) {
            ((INetError) throwable).onError(request, apiViewModel);
        }
    }
}
