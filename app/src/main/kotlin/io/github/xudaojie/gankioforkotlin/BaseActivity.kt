package io.github.xudaojie.gankioforkotlin

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window

/**
 * Created by xdj on 16/9/5.
 */

open class BaseActivity : AppCompatActivity() {
    protected val mActivity: Activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
//        window.enterTransition = Explode()
//        window.exitTransition = Explode()
    }
}