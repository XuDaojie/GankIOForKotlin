package io.github.xudaojie.gankioforkotlin

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by xdj on 16/9/5.
 */

class BaseActivity : AppCompatActivity() {
    protected var mActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
    }
}
