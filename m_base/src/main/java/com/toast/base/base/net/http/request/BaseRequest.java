package com.toast.base.base.net.http.request;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toast.base.base.net.error.NullError;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava2.Result;

/**
 * desc: <br/>
 * time: 2020/11/17 19:31 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class BaseRequest<T> {

    /**
     * body 请求方式，fields最大数
     */
    private static final int BODY_MAX_FIELDS = 2;
    /**
     * 全路径url
     */
    private String url;
    /**
     * request body
     * 如：请求参数model、MultipartBody(上传使用)、或其他(根据具体确定)
     */
    private Object body;
    /**
     * 传递给服务端的参数字段
     * 1. get方式的 QueryMap
     * 2. post方式，form形式fields
     * 3. post方式，body形式fields(如果body为null的情况)
     */
    private Map<String, Object> fields;
    /**
     * request headers
     */
    private Map<String, Object> headers;
    /**
     * 请求唯一标识
     * 该参数仅标识这个请求，并不会发送到服务端
     */
    private Object flag;
    /**
     * 数据返回类型
     */
    private Class<T> dataType;
    /**
     * 请求结果转换器
     */
    private Function<Result<ResponseBody>, Observable<T>> dataConverter;


    BaseRequest(@NonNull String url) {
        this(url, null, null);
    }

    BaseRequest(@NonNull String url, Class<T> dataType) {
        this(url, null, dataType);
    }

    BaseRequest(@NonNull String url, Object body, Class<T> dataType) {
        this.url = url;
        this.body = body;
        this.dataType = dataType;
    }

    // ====================== 数据转换

    /**
     * 转换Http返回结果
     */
    public Observable<T> convertResult(@NonNull Result<ResponseBody> result) {
        try {
            if (dataConverter != null) {
                return dataConverter.apply(result);
            } else if (getDataConverter() != null) {
                return getDataConverter().apply(result);
            } else {
                return convertToBean(result);
            }
        } catch (Exception e) {
            return Observable.error(new Exception());
        }
    }

    private Observable<T> convertToBean(@NonNull Result<ResponseBody> result) throws IOException {
        String serverResponse = getContent(result);

        if (TextUtils.isEmpty(serverResponse)) {
            return Observable.error(new NullError("server response is empty!" + this.toString()));
        }

        return null;
    }

    @Nullable
    private String getContent(Result<ResponseBody> result) throws IOException {
        if ((result.response() != null)
                && (result.response().body() != null)) {
            return result.response().body().string();
        }

        return null;
    }

    public String getUrl() {
        return url;
    }

    public BaseRequest<T> setUrl(String url) {
        this.url = url;
        return this;
    }

    public Object getBody() {
        return body;
    }

    public BaseRequest<T> setBody(Object body) {
        this.body = body;
        return this;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public BaseRequest<T> setFields(Map<String, Object> fields) {
        this.fields = fields;
        return this;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public BaseRequest<T> setHeaders(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }

    public Object getFlag() {
        return flag;
    }

    public BaseRequest<T> setFlag(Object flag) {
        this.flag = flag;
        return this;
    }

    public Class<T> getDataType() {
        return dataType;
    }

    public BaseRequest<T> setDataType(Class<T> dataType) {
        this.dataType = dataType;
        return this;
    }

    public BaseRequest<T> setDataConverter(Function<Result<ResponseBody>, Observable<T>> dataConverter) {
        this.dataConverter = dataConverter;
        return this;
    }

    protected Function<Result<ResponseBody>, Observable<T>> getDataConverter() {
        // 子类实现
        return null;
    }

    @Override
    public String toString() {
        return ", " + getClass().getSimpleName() +"{" +
                "url='" + url + '\'' +
                ", body=" + body +
                ", fields=" + fields +
                ", headers=" + headers +
                ", flag=" + flag +
                ", dataType=" + dataType +
                ", dataConverter=" + dataConverter +
                '}';
    }
}
