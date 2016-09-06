package io.github.xudaojie.gankioforkotlin

import io.github.xudaojie.gankioforkotlin.bean.GankData
import io.github.xudaojie.gankioforkotlin.data.Api
import io.github.xudaojie.gankioforkotlin.data.remote.GankIoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by xdj on 16/9/6.
 */

class Test1 {

    private var mRetrofit: Retrofit? = null

    init {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder().build()
        }

        val service = Api.INSTANCE.net().create(GankIoService::class.java)
        service.data("", 1, 1).enqueue(object : Callback<GankData> {
            override fun onResponse(call: Call<GankData>, response: Response<GankData>) {

            }

            override fun onFailure(call: Call<GankData>, throwable: Throwable) {

            }
        })
    }
}
