package com.toast.m_base.base.net.http.retrofit;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * desc:  <br/>
 * time: 2020/11/15 17:45 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public class RetrofitManager {

    private static Retrofit retrofit;

    private void init() {
        Retrofit.Builder builder = new Retrofit.Builder();

        // TODO 此处可获取 AppConfig 中的SeverUrl
        String baseUrl = "http://www.baidu.com";

        builder.baseUrl(baseUrl + "/")
                .client(OkHttpManager.getInstance().getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitManager getInstance() {
        if (retrofit == null) {
            RetrofitClientHolder.INSTANCE.init();
        }
        return RetrofitClientHolder.INSTANCE;
    }

    public <T> T createService(Class<T> service) {
        return retrofit.create(service);
    }

    static class RetrofitClientHolder {
        static final RetrofitManager INSTANCE = new RetrofitManager();
    }
}
