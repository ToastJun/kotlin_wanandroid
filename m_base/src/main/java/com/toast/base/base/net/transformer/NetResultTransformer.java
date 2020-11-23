package com.toast.base.base.net.transformer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toast.base.base.net.http.IApiViewModel;
import com.toast.base.base.net.http.request.BaseRequest;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava2.Result;

/**
 * desc: <br/>
 * time: 2020/11/23 17:59 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class NetResultTransformer<T> extends TransformerBase<Result<ResponseBody>, T> {

    @Nullable
    private IApiViewModel apiViewModel;
    /**
     * 当前请求参数
     */
    @NonNull
    private BaseRequest<T> request;


    public NetResultTransformer(@NonNull BaseRequest<T> request) {
        this(request, null);
    }

    public NetResultTransformer(@NonNull BaseRequest<T> request, @Nullable IApiViewModel apiViewModel) {
        this.request= request;
        this.apiViewModel = apiViewModel;
    }

    @Override
    public ObservableSource<T> apply(Observable<Result<ResponseBody>> upstream) {
        return null;
    }
}
