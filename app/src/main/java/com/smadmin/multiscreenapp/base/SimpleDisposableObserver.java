package com.smadmin.multiscreenapp.base;

import android.util.Log;

import io.reactivex.observers.DisposableObserver;

public class SimpleDisposableObserver<T> extends DisposableObserver<T> {

    private static final String TAG = SimpleDisposableObserver.class.getSimpleName();

    @Override
    public void onNext(T element) {

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, e.getMessage(), e);
    }

    @Override
    public void onComplete() {

    }
}
