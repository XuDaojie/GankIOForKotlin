package io.github.xudaojie.gankioforkotlin

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by xdj on 16/9/6.
 */

open class BaseFragment : Fragment() {
    protected var mActivity: Activity? = null
    protected var mRoot: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
    }

}
