package com.toast.m_base.base.net.http.retrofit.interceptor;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toast.m_base.base.net.http.retrofit.interceptor.lambda.Consumer3;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.function.Function;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * desc: 请求时间拦截器 <br/>
 * time: 2020/11/15 21:38 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public class TimeWatchInterceptor implements Interceptor {

    private Function<Chain, Response> customOperation;

    private Consumer3<Chain, Long, Response> timeOperation;

    public TimeWatchInterceptor() { }

    public TimeWatchInterceptor(Consumer3<Chain, Long, Response> customOperation) {
        this.timeOperation = customOperation;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        if (customOperation == null) {
            return doDefaultOperation(chain, timeOperation);
        } else {
            return doCustomOperation(chain, customOperation);
        }
    }

    @NonNull
    private Response doDefaultOperation(@NonNull Chain chain,
                                        @Nullable Consumer3<Chain, Long, Response> timeOperation) throws IOException {
        long beginTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        long useTime = System.currentTimeMillis() - beginTime;
        if (timeOperation == null) {
            Log.v("TimeWatchInterceptor",
                    "useTime[" + useTime + "] -> url" + chain.request().url());
        } else {
            try {
                timeOperation.accept(chain, useTime, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return response;
    }

    @NonNull
    private Response doCustomOperation(Chain chain, Function<Chain, Response> customOperation) throws IOException {
        Response response = null;

        try {
            response = customOperation.apply(chain);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response != null ? response : chain.proceed(chain.request());
    }
}
