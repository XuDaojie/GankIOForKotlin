package io.github.xudaojie.gankioforkotlin.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.detail.DetailActivity

/**
 * Created by xdj on 16/9/5.
 */
class HomeListAdapter(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var vh = holder as MyViewHolder
        vh.itemView.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            context.startActivity(i)
        }
        vh.bindViewHolder()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View? = LayoutInflater.from(context)
                .inflate(R.layout.gank_list_item, parent, false)
        return MyViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return 15
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder() {
        }
    }
}