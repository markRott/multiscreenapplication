package com.smadmin.multiscreenapp.base;

import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<View extends IBaseMvpView> extends MvpPresenter<View> {

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    protected void addDisposable(Disposable localDisposable) {
        if (localDisposable == null) return;
        compositeDisposable.add(localDisposable);
    }

    private void dispose() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
