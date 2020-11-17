package com.toast.base.base.net.http;

import com.toast.base.base.net.http.retrofit.RetrofitManager;

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
    private static Object emptyParams;


    //====================== post body


    //====================== 其他

    static <T> T createService(Class<T> service) {
        return RetrofitManager.getInstance().createService(service);
    }

}
