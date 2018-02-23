package com.example.micha.googlemapsagain.maps;

import android.location.Location;

import com.example.micha.googlemapsagain.BasePresenter;
import com.example.micha.googlemapsagain.BaseView;
import com.example.micha.googlemapsagain.model.Result;

import java.util.List;

/**
 * Created by micha on 2/23/2018.
 */

public interface MapsContract {
    interface MView extends BaseView{
        void sendResults(List<Result> results);
    }

    interface MPresenter extends BasePresenter<MView> {
        void locationCall(Location location);
    }
}
