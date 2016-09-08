package io.github.xudaojie.gankioforkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.xudaojie.gankioforkotlin.R
import kotlinx.android.synthetic.main.detail_list_item.view.*

/**
 * Created by xdj on 16/9/5.
 */
class DetailListAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val vh = holder as MyViewHolder
        vh.bindViewHolder()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View? = LayoutInflater.from(context)
                .inflate(R.layout.detail_list_item, parent, false)
        return MyViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return 15
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder() {
            itemView.text1.text = "xxxx"
        }
    }
}