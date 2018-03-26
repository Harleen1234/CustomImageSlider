
package com.imageslider;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android3 on 30/8/16.
 */
public class RestApi {

    /**
     * Retrofit Service
     * we are setting base url,converter for serialization and deserialzation the object
     * which is coming from server side.
     * client for setting the time 30 seconds if the responce is not coming
     * @return service
     */
    public Service createService(String base_url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
        Service service = retrofit.create(Service.class);
        return  service;
    }

    /**
     * HttpLoggingInterceptor is used for displaying the body of the sender and receiver responce
     * in  form of JSONOBJECT
     * and setting connecttimeout,readtimeout etc.
     * @return
     */
    private OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
        return client;
    }
}
