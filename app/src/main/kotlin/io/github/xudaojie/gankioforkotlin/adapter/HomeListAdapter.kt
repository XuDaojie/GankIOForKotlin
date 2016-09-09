package io.github.xudaojie.gankioforkotlin.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.bean.GankData
import io.github.xudaojie.gankioforkotlin.detail.DetailActivity
import kotlinx.android.synthetic.main.gank_list_item.view.*

/**
 * Created by xdj on 16/9/5.
 */
class HomeListAdapter(val context: Context, val values: GankData) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val vh = holder as MyViewHolder
        vh.itemView.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
//            context.startActivity(i)
            i.putExtra("url", values.results!![position].url)
            context.startActivity(i,
                    ActivityOptions.makeSceneTransitionAnimation(
                            context as Activity, holder.itemView, "image").toBundle())
        }
        vh.bindViewHolder(values.results!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View? = LayoutInflater.from(context)
                .inflate(R.layout.gank_list_item, parent, false)
        return MyViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return values.results!!.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViewHolder(result: GankData.ResultsBean) {
            Picasso.with(context)
                    .load(result.url)
                    .into(itemView.image)
        }
    }
}