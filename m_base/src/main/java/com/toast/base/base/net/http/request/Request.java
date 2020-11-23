package com.toast.base.base.net.http.request;

import androidx.annotation.NonNull;

import com.toast.base.base.net.entity.BaseDataBean;

/**
 * desc: <br/>
 * time: 2020/11/23 15:09 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class Request<T extends BaseDataBean> extends BaseRequest<T> {

    public Request(@NonNull String url) {
        super(url);
    }

    public Request(@NonNull String url, Class<T> dataType) {
        super(url, dataType);
    }

    public Request(@NonNull String url, Object body, Class<T> dataType) {
        super(url, body, dataType);
    }


}
