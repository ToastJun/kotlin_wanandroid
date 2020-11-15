package com.toast.m_base.base.net.http.retrofit.interceptor.lambda;

/**
 * desc: 接受3个参数的 Consumer <br/>
 * time: 2020/11/15 21:42 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public interface Consumer3<T1, T2, T3> {

    void accept(T1 t1, T2 t2, T3 t3) throws Exception;
}
