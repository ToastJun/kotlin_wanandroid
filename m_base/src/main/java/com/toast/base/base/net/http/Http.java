package com.toast.base.base.net.http;

import androidx.annotation.NonNull;

import com.toast.base.base.net.http.request.BaseRequest;
import com.toast.base.base.net.http.request.Request;
import com.toast.base.base.net.http.retrofit.RetrofitManager;
import com.toast.base.base.net.transformer.NetResultTransformer;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava2.Result;

/**
 * desc:  Http 通信类  <br/>
 * time: 2020/11/15 13:49 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
class Http {

    /**
     * 默认空 body
     */
    private static Object emptyBody;
    /**
     * 默认空 参数
     */
    private static Map<String, Object> emptyParams;


    //====================== post body

    /**
     * post请求,(Retrofit @Body 方式)
     *
     * @param request 具体请求
     * @param <T>     转换的数据类型
     * @return RxJava Observable
     */
    static <T> Observable<T> postBody(@NonNull BaseRequest<T> request) {
        return postBody(request, new NetResultTransformer<T>(request));
    }

    /**
     * post请求,(Retrofit @Body 方式)
     *
     * @param request     具体请求
     * @param transformer 自定义数据返回解析器
     * @param <T>         转换的数据类型
     * @return RxJava Observable
     */
    static <T> Observable<T> postBody(@NonNull BaseRequest<T> request,
                                      @NonNull ObservableTransformer<Result<ResponseBody>, T> transformer) {
        return createService(IHttpService.class)
                .postBody(request.getUrl(), getBody(request.getBody()), getMap(request.getHeaders()))
                .compose(transformer);
    }

    //====================== 其他

    static <T> T createService(Class<T> service) {
        return RetrofitManager.getInstance().createService(service);
    }

    @NonNull
    private static Object getBody(Object requestBody) {
        if (requestBody != null) {
            return requestBody;
        } else {
            if (emptyBody == null) {
                emptyBody = new Object();
            }

            return emptyBody;
        }
    }

    @NonNull
    private static Map<String, Object> getMap(Map<String, Object> params) {
        if (params != null) {
            return params;
        } else {
            if (emptyParams == null) {
                emptyParams = new HashMap<>();
            }

            return emptyParams;
        }
    }
}
