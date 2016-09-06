package io.github.xudaojie.gankioforkotlin.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xdj on 16/9/5.
 */
enum class Api {

    INSTANCE;

    private var mRetrofit: Retrofit? = null

    fun net(): Retrofit {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder()
                    .baseUrl("http://gank.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttp())
                    .build()
        }
        return mRetrofit!!
    }

    fun getHttp(): OkHttpClient {
        val httpLogging = HttpLoggingInterceptor()
        httpLogging.level = HttpLoggingInterceptor.Level.BODY
        val http = OkHttpClient.Builder()
                .addInterceptor(httpLogging)
                .build()

        return http
    }
}
