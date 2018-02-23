package com.example.micha.googlemapsagain.detail;

/**
 * Created by micha on 2/23/2018.
 */

public class DetailPresenter implements DetailContract.DPresenter {

    DetailContract.DView view;


    @Override
    public void attachView(DetailContract.DView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
