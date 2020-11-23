package com.toast.base.base.net.http;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.toast.base.base.net.action.IViewAction;

/**
 * desc: api 通信 View Model <br/>
 * time: 2020/11/23 18:23 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public interface IApiViewModel {

    /**
     * 获取网络动作处理LiveData
     *
     * @return live data
     */
    @NonNull
    MutableLiveData<IViewAction> getViewAction();

    /**
     * 在页面中执行相关业务
     *
     * @param apiViewModel  通信接口 model
     * @param viewAction    在页面中执行的业务代码
     */
    static void callViewAction(@Nullable IApiViewModel apiViewModel, IViewAction viewAction) {
        if (apiViewModel != null) {
            // TODO: 2020/11/23 TOAST 使用全局的 Handler
            new Handler(Looper.getMainLooper()).post(() -> {
                apiViewModel.getViewAction().setValue(viewAction);
            });
        }
    }
}
