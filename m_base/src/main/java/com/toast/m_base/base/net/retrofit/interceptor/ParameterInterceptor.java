package com.toast.m_base.base.net.http.retrofit.interceptor;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.toast.core.tool.ToolText;
import com.toast.m_base.base.net.http.retrofit.interceptor.parameter.DefaultParameterHelper;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * desc: 默认请求公共参数拦截器 <br/>
 * time: 2020/11/15 20:31 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public class ParameterInterceptor implements Interceptor {

    private DefaultParameterHelper defaultParameterHelper;


    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = setDefaultParamsToHeader(chain);
        return chain.proceed(request);
    }

    private Request setDefaultParamsToHeader(@NonNls Chain chain) {
        Request originRequest = chain.request();
        Map<String, Object> defaultParamMap = getDefaultParameterHelper().createParams();
        removeParamsIfRequestHeaderHasTheKey(defaultParamMap, originRequest);

        return addDefaultParamsToHeader(originRequest, defaultParamMap);
    }

    private DefaultParameterHelper getDefaultParameterHelper() {
        if (defaultParameterHelper == null) {
            defaultParameterHelper = new DefaultParameterHelper();
        }
        return defaultParameterHelper;
    }

    /**
     * 如果原始请求中有相同的header，则删除默认请求头列表中的参数，使用原始header
     */
    private void removeParamsIfRequestHeaderHasTheKey(@NonNull Map<String, Object> defaultParamMap,
                                                      @NonNull Request originRequest) {
        List<String> deleteHeaderKeyList = new ArrayList<>(2);
        defaultParamMap.forEach((paramKey, paramValue) -> {
            if (ToolText.isNotEmpty(originRequest.header(paramKey))) {
                deleteHeaderKeyList.add(paramKey);
            }
        });

        deleteHeaderKeyList.stream().forEach(defaultParamMap::remove);
    }

    private Request addDefaultParamsToHeader(@NonNull Request originRequest,
                                          @NonNull Map<String, Object> defaultParamsMap) {
        Request.Builder requestBuilder = originRequest.newBuilder();

        defaultParamsMap.forEach((headerKey, headerValue) -> {
            if (ToolText.isNotEmpty(headerKey)
                    && (headerValue != null) && ToolText.isNotEmpty(headerValue.toString())) {
                requestBuilder.header(headerKey, headerValue.toString());
            }
        });

        return requestBuilder.build();
    }
}
