package com.toast.base.base.net.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * desc: 服务端 data 基类 <br/>
 * time: 2020/11/23 16:53 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public abstract class BaseDataBean implements Parcelable {

    /**
     * 结果码
     */
    private int superCode;
    /**
     * 结果信息
     */
    private String superMessage;

    public int getSuperCode() {
        return superCode;
    }

    public void setSuperCode(int superCode) {
        this.superCode = superCode;
    }

    public String getSuperMessage() {
        return superMessage;
    }

    public void setSuperMessage(String superMessage) {
        this.superMessage = superMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.superCode);
        dest.writeString(this.superMessage);
    }

    public BaseDataBean() {
    }

    protected BaseDataBean(Parcel in) {
        this.superCode = in.readInt();
        this.superMessage = in.readString();
    }
}
