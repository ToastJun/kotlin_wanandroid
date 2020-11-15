package com.toast.m_base.base.net.http.retrofit.interceptor.parameter;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 默认功能参数, http通信,h5通信都可使用 <br/>
 * time: 2020/11/15 20:45 <br/>
 * author: Toast <br/>
 * since: V 1.0 <br/>
 */
public class DefaultParameterHelper {

    /**
     * 创建公共参数
     */
    @NonNull
    public Map<String, Object> createParams() {
        HashMap<String, Object> headerParams = new HashMap<>();

        // TODO: 2020/11/15 设置header公共参数

        return headerParams;
    }
}
