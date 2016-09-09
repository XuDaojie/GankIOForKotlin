package io.github.xudaojie.gankioforkotlin.home

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.github.xudaojie.gankioforkotlin.BaseFragment
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.adapter.HomeListAdapter
import io.github.xudaojie.gankioforkotlin.bean.GankData
import io.github.xudaojie.gankioforkotlin.data.Api
import io.github.xudaojie.gankioforkotlin.data.remote.GankIoService
import io.github.xudaojie.gankioforkotlin.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.home_frag.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by xdj on 16/9/6.
 */

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mRoot = inflater!!.inflate(R.layout.home_frag, container, false)
        // 快速滑动时可能会出现item互相交错
//        val adapter = SlideInBottomAnimationAdapter(ListAdapter(mActivity!!))
//        val adapter = HomeListAdapter(mActivity!!)
        val divider = DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL)
        divider.divider = ContextCompat.getDrawable(mActivity, R.drawable.divider_8dp)
//
        mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        mRoot!!.recycler_view.addItemDecoration(divider)
//        mRoot!!.recycler_view.adapter = adapter

        mRoot!!.refresh_layout.setOnRefreshListener {
//            val adapter = HomeListAdapter(mActivity!!, )
//            mRoot!!.recycler_view.adapter = adapter
//            mRoot!!.refresh_layout.isRefreshing = false
        }

        val service = Api.INSTANCE.net().create(GankIoService::class.java)
        service.data("福利", 20, 1).enqueue(object : Callback<GankData> {
            override fun onResponse(call: Call<GankData>?, response: Response<GankData>?) {
                val adapter = HomeListAdapter(mActivity!!, response!!.body())
                mRoot!!.recycler_view.adapter = adapter
            }

            override fun onFailure(call: Call<GankData>?, e: Throwable?) {
                Toast.makeText(mActivity, e.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        return mRoot
    }
}
