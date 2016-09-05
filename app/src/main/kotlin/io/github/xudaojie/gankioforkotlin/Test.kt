package io.github.xudaojie.gankioforkotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView

/**
 * Created by xdj on 16/9/5.
 */

class Test {
    internal inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.image) as ImageView
        }
    }
}
