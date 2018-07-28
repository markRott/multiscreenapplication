package com.smadmin.multiscreenapp.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {

    private PublishSubject<Object> subject = PublishSubject.create();

    public void sendData(Object object) {
        subject.onNext(object);
    }

    public Observable<Object> getSubject() {
        return subject;
    }
}
