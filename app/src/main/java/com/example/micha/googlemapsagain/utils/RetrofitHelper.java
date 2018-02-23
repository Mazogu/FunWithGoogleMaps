package com.example.micha.googlemapsagain.utils;

import com.example.micha.googlemapsagain.model.Compass;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by micha on 2/23/2018.
 */

public class RetrofitHelper {


    public static class Factory{
        public static Retrofit getRetrofit(String url){
            return new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    public static Observable<Compass> getCompass(String url, String location,int radius,String key){
        RetrofitService service = Factory.getRetrofit(url).create(RetrofitService.class);
        return service.getCompass(location, radius, key);
    }


    public interface RetrofitService{
        @GET("json?query=BBVA+Compass")
        Observable<Compass> getCompass(@Query("location") String location, @Query("radius") int radius ,@Query("key") String key);

    }
}
