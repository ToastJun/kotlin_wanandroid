package com.toast.m_base.base.net.http;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * desc: 通用Http Service 请求 <br/>
 * time: 2020/11/15 23:24 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public interface IHttpService {

    /**
     * get 请求方式
     *
     * @param url       请求地址
     * @param params    拼接在url地址参数
     * @param headers   传递的header参数
     * @return  数据通信结果
     */
    @GET
    Observable<Result<ResponseBody>> get(@Url String url,
                                         @QueryMap Map<String, Object> params,
                                         @HeaderMap Map<String, Object> headers);


    /**
     * post 请求方式
     *
     * @param url           请求地址
     * @param bodyParams    请求body参数
     * @param headers       传递的header参数
     * @return  数据通信结果
     */
    @POST
    Observable<Result<ResponseBody>> postBody(@Url String url,
                                              @Body Object bodyParams,
                                              @HeaderMap Map<String, Object> headers);


    /**
     * post form 请求方式
     *
     * @param url           请求地址
     * @param params        form参数
     * @param headers       传递的header参数
     * @return  数据通信结果
     */
    @FormUrlEncoded
    @POST
    Observable<Result<RequestBody>> postForm(@Url String url,
                                             @FieldMap Map<String, Object> params,
                                             @HeaderMap Map<String, Object> headers);

    /**
     * 下载文件
     *
     * @param url   下载地址
     * @return  数据通信结果
     */
    @GET
    @Streaming
    Observable<Result<ResponseBody>> download(@Url String url);

    /**
     * 上传文件
     *
     * @param url           请求地址
     * @param multipartBody compliant request body
     * @param headers       传递的header参数
     * @return  数据通信结果
     */
    @POST
    Observable<Result<ResponseBody>> upload(@Url String url,
                                            @Body MultipartBody multipartBody,
                                            @HeaderMap Map<String, Object> headers);
}
