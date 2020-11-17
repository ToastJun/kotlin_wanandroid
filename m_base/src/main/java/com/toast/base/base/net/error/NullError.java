package com.toast.base.base.net.error;

import androidx.annotation.NonNull;

import com.toast.base.base.net.error.base.BaseNetError;

/**
 * desc: <br/>
 * time: 2020/11/17 20:54 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public class NullError extends BaseNetError {

    public NullError(@NonNull String errorMessage) {
        super(new NullPointerException(errorMessage));
    }

    @NonNull
    @Override
    public String key() {
        return "NullError";
    }
}
