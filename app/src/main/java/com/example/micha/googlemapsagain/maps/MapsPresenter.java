package com.example.micha.googlemapsagain.maps;

import android.location.Location;
import android.util.Log;

import com.example.micha.googlemapsagain.model.Compass;
import com.example.micha.googlemapsagain.model.Result;
import com.example.micha.googlemapsagain.utils.RetrofitHelper;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by micha on 2/23/2018.
 */

public class MapsPresenter implements MapsContract.MPresenter {

    MapsContract.MView view;
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/";
    public static final String TAG = MapsPresenter.class.getSimpleName();

    @Override
    public void attachView(MapsContract.MView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void locationCall(Location location) {
        String lat = Double.toString(location.getLatitude());
        String lo = Double.toString(location.getLongitude());
        String local = lat+","+lo;
        RetrofitHelper.getCompass(BASE_URL, local, 10000, "AIzaSyCdGSfdRw0LFakFaR0JiueyJBYo_coFubs")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Compass>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Compass compass) {
                        view.sendResults(compass.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
