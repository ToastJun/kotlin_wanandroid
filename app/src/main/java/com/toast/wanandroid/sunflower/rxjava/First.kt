package com.toast.wanandroid.sunflower.rxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.ObservableEmitter

fun createObservableForTest(): Unit{
    // 创建一个被观察者 Observable
    Observable.create(ObservableOnSubscribe<String> { emitter ->
        emitter.onNext("1")
        emitter.onNext("2")
    })
        .subscribe(object: Observer<String> {

            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                println("onNext")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

        })
}