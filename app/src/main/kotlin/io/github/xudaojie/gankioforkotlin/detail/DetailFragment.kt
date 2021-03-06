package io.github.xudaojie.gankioforkotlin.detail

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import android.support.v7.widget.Toolbar
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
        mRoot!!.toolbar.inflateMenu(R.menu.detail_menu)
        mRoot!!.toolbar.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->
            val id = item.itemId
            if (id == R.id.action_share) {
                val dateFormat = TimeUtils.format(
                        TimeUtils.parse(mPublishedAt!!, "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"), "yyyy/MM/dd")

                var shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "干货集中营")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "【干货集中营】$dateFormat http://gank.io/$dateFormat")

                shareIntent = Intent.createChooser(shareIntent, "分享到...")
                startActivity(shareIntent)
                return@OnMenuItemClickListener true
            }
            false
        })

        Picasso.with(mActivity).load(mUrl).into(mRoot?.ivImage)

        val service = Api.INSTANCE.net().create(GankIoService::class.java)
        val dateFormat = TimeUtils.format(
                TimeUtils.parse(mPublishedAt!!, "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"), "yyyy/MM/dd")
        service.day(dateFormat).enqueue(object : Callback<DayData>{
            override fun onResponse(call: Call<DayData>?, response: Response<DayData>?) {
                // Setup expandable feature and RecyclerView
                val expMgr = RecyclerViewExpandableItemManager(null)
                expMgr.defaultGroupsExpandedState = true // 默认为展开状态

                mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity)
//                mRoot!!.recycler_view.adapter = expMgr.createWrappedAdapter(TestAdapter())
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
