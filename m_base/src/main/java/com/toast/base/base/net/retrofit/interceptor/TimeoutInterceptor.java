package com.toast.base.base.net.http.retrofit.interceptor;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.toast.core.tool.ToolNumber;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * desc: 超时拦截器 <br/>
 * time: 2020/11/15 19:42 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public class TimeoutInterceptor implements Interceptor {

    /**
     * 建立连接超时, {@link retrofit2.http.Header} key
     */
    public static final String CONNECT_TIMEOUT = "INTERCEPTOR_FLAG_CONNECT_TIMEOUT";
    /**
     * 读数据超时, {@link retrofit2.http.Header} key
     */
    public static final String READ_TIMEOUT = "INTERCEPTOR_FLAG_READ_TIMEOUT";
    /**
     * 写数据超时, {@link retrofit2.http.Header} key
     */
    public static final String WRITE_TIMEOUT = "INTERCEPTOR_FLAG_WRITE_TIMEOUT";


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (hasSpeciallyTimeOut(request)) {
            setTimeout(chain);
            request = buildRequestWithoutTimeout(chain);
        }

        return chain.proceed(request);
    }

    /**
     * 是否有特殊的超时设置
     *
     * @return true: 有
     */
    private boolean hasSpeciallyTimeOut(Request request) {
        return (!TextUtils.isEmpty(request.header(CONNECT_TIMEOUT))
                || (!TextUtils.isEmpty(request.header(READ_TIMEOUT)))
                || (!TextUtils.isEmpty(request.header(WRITE_TIMEOUT))));
    }

    /**
     * 重新设置超时时间
     */
    private void setTimeout(Chain chain) {
        Request request = chain.request();

        int connectTimeout = parseTimeout(request, CONNECT_TIMEOUT, chain.connectTimeoutMillis());
        chain.withConnectTimeout(connectTimeout, TimeUnit.SECONDS);

        int readTimeout = parseTimeout(request, READ_TIMEOUT, chain.connectTimeoutMillis());
        chain.withReadTimeout(readTimeout, TimeUnit.SECONDS);

        int writeTimeout = parseTimeout(request, WRITE_TIMEOUT, chain.connectTimeoutMillis());
        chain.withConnectTimeout(writeTimeout, TimeUnit.SECONDS);
    }

    /**
     * 解析超时时间
     * @param defaultTimeout 默认超时时间
     * @return 最终超时时间
     */
    private int parseTimeout(Request request, String connectTimeout, int defaultTimeout) {
        String timeout = request.header(connectTimeout);
        if (TextUtils.isEmpty(timeout)) {
            return defaultTimeout;
        }
        return ToolNumber.toInt(timeout);
    }

    /**
     * 创建不带 timeout header 的request
     */
    private Request buildRequestWithoutTimeout(@NonNull Chain chain) {
        return chain.request()
                .newBuilder()
                .removeHeader(CONNECT_TIMEOUT)
                .removeHeader(READ_TIMEOUT)
                .removeHeader(WRITE_TIMEOUT)
                .build();
    }
}
