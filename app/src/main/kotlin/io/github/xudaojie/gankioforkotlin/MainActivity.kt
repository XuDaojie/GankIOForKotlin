package io.github.xudaojie.gankioforkotlin

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.xudaojie.gankioforkotlin.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = ListAdapter(mActivity)
    }

}
