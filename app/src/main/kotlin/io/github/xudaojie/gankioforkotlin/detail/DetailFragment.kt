package io.github.xudaojie.gankioforkotlin.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.xudaojie.gankioforkotlin.BaseFragment
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.adapter.DetailListAdapter
import io.github.xudaojie.gankioforkotlin.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.detail_frag.view.*

/**
 * Created by xdj on 16/9/8.
 */

class DetailFragment : BaseFragment() {

    companion object {
        fun newInstance(): DetailFragment {
            return DetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mRoot = inflater!!.inflate(R.layout.detail_frag, container, false)

        val divider = DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL)
        divider.divider = ContextCompat.getDrawable(mActivity, R.drawable.divider_8dp)

        mRoot!!.recycler_view.addItemDecoration(divider)
        mRoot!!.recycler_view.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false)
        mRoot!!.recycler_view.adapter = DetailListAdapter(mActivity!!)

        return mRoot
    }
}
