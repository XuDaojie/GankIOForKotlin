package io.github.xudaojie.gankioforkotlin.home

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.xudaojie.gankioforkotlin.BaseFragment
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.adapter.ListAdapter
import io.github.xudaojie.gankioforkotlin.widget.DividerItemDecoration
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.home_frag.view.*

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
        val adapter = ScaleInAnimationAdapter(ListAdapter(mActivity!!))
        adapter.setDuration(300)
        adapter.setStartPosition(0)

        val divider = DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL)
        divider.divider = ContextCompat.getDrawable(mActivity, R.drawable.divider_8dp)

        mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        mRoot!!.recycler_view.adapter = adapter
        mRoot!!.recycler_view.addItemDecoration(divider)
        return mRoot
    }
}
