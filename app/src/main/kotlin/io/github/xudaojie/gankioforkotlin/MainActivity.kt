package io.github.xudaojie.gankioforkotlin

import android.os.Bundle
import io.github.xudaojie.gankioforkotlin.common.ActivityUtils
import io.github.xudaojie.gankioforkotlin.home.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_act)

        var fragment = supportFragmentManager.findFragmentById(R.id.content_frame)
        if (fragment == null) {
            fragment = HomeFragment.newInstance()
            ActivityUtils.addFragmentToActivity(supportFragmentManager, fragment, R.id.content_frame)
        }

//        val service = Api.INSTANCE.net().create(GankIoService::class.java)
//        service.day("2015/08/06").enqueue(object : Callback<DayData> {
//            override fun onResponse(call: Call<DayData>?, response: Response<DayData>?) {
//                Log.d("xxx", response?.message())
//            }
//
//            override fun onFailure(call: Call<DayData>?, e: Throwable?) {
//                Toast.makeText(mActivity, e.toString(), Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }

}
