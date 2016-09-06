package io.github.xudaojie.gankioforkotlin.data.remote

import io.github.xudaojie.gankioforkotlin.bean.GankData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by xdj on 16/9/6.
 */

interface Test {
    @GET("xxx")
    fun t1(@Path("xxx") xxx: String): Call<GankData>
}
