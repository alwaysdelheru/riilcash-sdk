package com.vitraining.riilcashsdk.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vitraining.riilcashsdk.util.Commons;
import com.vitraining.riilcashsdk.util.SharedData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context, String server_url) {
        if (retrofit==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            if (Commons.SHOW_DEV_LOG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);

                httpClient.addInterceptor(logging);
            }

            httpClient.addInterceptor(new AddCookiesInterceptor(context));
            httpClient.addInterceptor(new ReceivedCookiesInterceptor(context));

            retrofit = new Retrofit.Builder()
                    .baseUrl(server_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
