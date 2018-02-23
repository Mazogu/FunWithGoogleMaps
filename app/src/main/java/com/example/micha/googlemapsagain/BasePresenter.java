package com.example.micha.googlemapsagain;

/**
 * Created by micha on 2/23/2018.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
