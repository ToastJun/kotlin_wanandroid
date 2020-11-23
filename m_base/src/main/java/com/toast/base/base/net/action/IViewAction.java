package com.toast.base.base.net.action;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

import com.toast.base.base.activity.IBaseView;

/**
 * desc: View Action <br/>
 * time: 2020/11/23 19:56 <br/>
 * author: toast <br/>
 * since: V 1.0 <br/>
 */
public interface IViewAction {

    /**
     * 执行页面业务动作
     *
     * @param baseView  页面。
     *                  注意，该参数不能保存在实现类的成员变量中，否则会内存泄露。
     */
    @MainThread
    void call(@NonNull IBaseView<?> baseView);
}
