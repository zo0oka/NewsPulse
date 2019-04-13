package com.zo0okadev.newspulse.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zo0okadev.newspulse.utils.Constants.NEWS_API_URL;

public class NewsApiClient {

    private static NewsApi sInstance = null;

    public static NewsApi getInstance() {

        if (sInstance == null) {

            // For logging
//            HttpLoggingInterceptor loggingInterceptor =
//                    new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

            // Building OkHttp client
            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(loggingInterceptor)
                    .build();

            // Retrofit Builder
            Retrofit.Builder builder =
                    new Retrofit
                            .Builder()
                            .baseUrl(NEWS_API_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create());

            sInstance = builder.build().create(NewsApi.class);

        }

        return sInstance;
    }
}
