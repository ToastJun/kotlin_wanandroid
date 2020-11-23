package com.toast.base.base.net.entity;

/**
 * desc: Remote Bean 通用类 <br/>
 * 注意: 该类没有被序列化
 *
 * time: 2020/11/23 17:05 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class RemoteBean<T extends BaseDataBean> {
    /**
     * 业务code码
     */
    private int code;
    /**
     * 业务信息
     */
    private String message;
    /**
     * 具体业务数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T setValuesToData() {
        if (data != null) {
            this.data.setSuperCode(this.code);
            this.data.setSuperMessage(this.message);
        }
        return data;
    }
}
