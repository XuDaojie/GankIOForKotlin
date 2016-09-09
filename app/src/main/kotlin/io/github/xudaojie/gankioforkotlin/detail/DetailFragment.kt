package io.github.xudaojie.gankioforkotlin.detail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager
import com.squareup.picasso.Picasso
import io.github.xudaojie.gankioforkotlin.BaseFragment
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.adapter.DetailListAdapter
import io.github.xudaojie.gankioforkotlin.bean.DayData
import io.github.xudaojie.gankioforkotlin.common.TimeUtils
import io.github.xudaojie.gankioforkotlin.data.Api
import io.github.xudaojie.gankioforkotlin.data.remote.GankIoService
import kotlinx.android.synthetic.main.detail_frag.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by xdj on 16/9/8.
 */

class DetailFragment : BaseFragment() {

    companion object {
        fun newInstance(url: String, publishedAt: String): DetailFragment {
            val args = Bundle()
            args.putString("url", url)
            args.putString("published_at", publishedAt)
            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var mUrl: String? = null
    private var mPublishedAt: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUrl = arguments?.getString("url")
        mPublishedAt = arguments?.getString("published_at")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mRoot = inflater!!.inflate(R.layout.detail_frag, container, false)

        Picasso.with(mActivity).load(mUrl).into(mRoot?.ivImage)

        val service = Api.INSTANCE.net().create(GankIoService::class.java)
        val dateFormat = TimeUtils.format(
                TimeUtils.parse(mPublishedAt!!, "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"), "yyyy/MM/dd")
        service.day(dateFormat).enqueue(object : Callback<DayData>{
            override fun onResponse(call: Call<DayData>?, response: Response<DayData>?) {
//                val expMgr = RecyclerViewExpandableItemManager(null)
//                expMgr.defaultGroupsExpandedState = true
//
////                mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
//                mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity)
//                mRoot!!.recycler_view.adapter = expMgr.createWrappedAdapter(DetailListAdapter(mActivity!!, response!!.body()))
//
//                // NOTE: need to disable change animations to ripple effect work properly
//                (mRoot!!.recycler_view.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
//                expMgr.attachRecyclerView(mRoot!!.recycler_view)

                // Setup expandable feature and RecyclerView
                val expMgr = RecyclerViewExpandableItemManager(null)

                mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity)
                mRoot!!.recycler_view.adapter = expMgr.createWrappedAdapter(DetailListAdapter(mActivity!!, response!!.body()))

                // NOTE: need to disable change animations to ripple effect work properly
                (mRoot!!.recycler_view.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

                expMgr.attachRecyclerView(mRoot!!.recycler_view)
            }

            override fun onFailure(call: Call<DayData>?, t: Throwable?) {
                Log.wtf("xxx", t)
            }

        })

        return mRoot
    }
}
