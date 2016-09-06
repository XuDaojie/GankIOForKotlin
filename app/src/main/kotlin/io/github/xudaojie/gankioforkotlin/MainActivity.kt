package io.github.xudaojie.gankioforkotlin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.github.xudaojie.gankioforkotlin.adapter.ListAdapter
import io.github.xudaojie.gankioforkotlin.bean.DayData
import io.github.xudaojie.gankioforkotlin.data.Api
import io.github.xudaojie.gankioforkotlin.data.remote.GankIoService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = ListAdapter(mActivity)

        val service = Api.INSTANCE.net().create(GankIoService::class.java)
        service.day("2015/08/06").enqueue(object : Callback<DayData> {
            override fun onResponse(call: Call<DayData>?, response: Response<DayData>?) {
                Log.d("xxx", response?.message())
            }

            override fun onFailure(call: Call<DayData>?, e: Throwable?) {
                Toast.makeText(mActivity, e.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }

}
