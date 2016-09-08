package io.github.xudaojie.gankioforkotlin

import android.app.Activity
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by xdj on 16/9/6.
 */

abstract class TestBaseFragment : Fragment() {
    protected var mRoot: View? = null

    protected abstract var mActivity: Activity

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
    }

}
