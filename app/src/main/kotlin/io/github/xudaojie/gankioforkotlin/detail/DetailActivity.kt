package io.github.xudaojie.gankioforkotlin.detail

import android.os.Bundle
import io.github.xudaojie.gankioforkotlin.BaseActivity
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.common.ActivityUtils

/**
 * Created by xdj on 16/9/8.
 */

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_compat_act)

        var fragment = supportFragmentManager.findFragmentById(R.id.content_frame)
        if (fragment == null) {
            fragment = DetailFragment.newInstance()
            ActivityUtils.addFragmentToActivity(supportFragmentManager, fragment, R.id.content_frame)
        }
    }
}
