package com.toast.m_base.base.net.http.retrofit;

import com.toast.m_base.base.net.http.retrofit.interceptor.ParameterInterceptor;
import com.toast.m_base.base.net.http.retrofit.interceptor.TimeWatchInterceptor;
import com.toast.m_base.base.net.http.retrofit.interceptor.TimeoutInterceptor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * desc:  <br/>
 * time: 2020/11/15 19:27 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public class OkHttpManager {

    /**
     * OkHttpClient
     */
    private static OkHttpClient okHttpClient;

    public synchronized static OkHttpManager getInstance() {
        if (okHttpClient == null) {
            OkHttpManagerCreateHolder.INSTANCE.init();
        }
        return OkHttpManagerCreateHolder.INSTANCE;
    }

    OkHttpClient getClient() {
        return okHttpClient;
    }

    private void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        initOkHttpDefaultConfig(builder);
        initOkHttpDebugConfig(builder);
        okHttpClient = builder.build();
    }

    /**
     * 初始化 HttpClient 默认配置
     */
    private void initOkHttpDefaultConfig(OkHttpClient.Builder builder) {
        builder
                // 超时
                .addInterceptor(new TimeoutInterceptor())
                // 公共参数
                .addInterceptor(new ParameterInterceptor())
                // 请求时间监测
                .addInterceptor(new TimeWatchInterceptor());
    }

    /**
     * 初始化 HttpClient 测试环境配置
     */
    private void initOkHttpDebugConfig(OkHttpClient.Builder builder) {
        builder
                // log
                .addInterceptor(createLogInterceptor());
    }

    private HttpLoggingInterceptor createLogInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    private void watchTime(Interceptor.Chain chain, long requestUseTime, Response response) {
        // TODO: 2020/11/15 请求时间观察 doSomeThing
    }

    static class OkHttpManagerCreateHolder {
        private static final OkHttpManager INSTANCE = new OkHttpManager();
    }
}
