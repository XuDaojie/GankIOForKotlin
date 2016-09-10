package io.github.xudaojie.gankioforkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder
import io.github.xudaojie.gankioforkotlin.R
import io.github.xudaojie.gankioforkotlin.bean.DayData
import kotlinx.android.synthetic.main.detail_child_item.view.*
import kotlinx.android.synthetic.main.detail_group_item.view.*

/**
 * Created by xdj on 16/9/5.
 */
class DetailListAdapter(val context: Context, val data: DayData) :
        AbstractExpandableItemAdapter<DetailListAdapter.GroupViewHolder, DetailListAdapter.ChildViewHolder>() {

    init {
        setHasStableIds(true) // this is required for expandable feature.
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.detail_child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindChildViewHolder(holder: ChildViewHolder?, groupPosition: Int, childPosition: Int, viewType: Int) {
        val category = data.category!![groupPosition]

        holder!!.bindViewHolder(getChildItem(category)[childPosition])
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return 0
    }

    override fun getGroupCount(): Int {
        return if (data.category == null) 0 else data.category!!.size
    }

    override fun getChildCount(groupPosition: Int): Int {
        val category = data.category!![groupPosition]
        return getChildItem(category).size
    }

    override fun onBindGroupViewHolder(holder: GroupViewHolder?, groupPosition: Int, viewType: Int) {
        holder?.bindViewHolder(data.category!![groupPosition])
    }

    override fun onCheckCanExpandOrCollapseGroup(holder: GroupViewHolder?, groupPosition: Int, x: Int, y: Int, expand: Boolean): Boolean {
        return true
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.detail_group_item, parent, false)
        return GroupViewHolder(view)
    }

    private fun getChildItem(category: String): List<DayData.ResultsBean.DataBean> {
        if (category.equals("iOS")) {
            return data.results?.ios!!
        } else if (category.equals("休息视频")) {
            return data.results?.video!!
        } else if (category.equals("拓展资源")) {
            return data.results?.resource!!
        } else if (category.equals("瞎推荐")) {
            return data.results?.recommend!!
        } else if (category.equals("福利")) {
            return data.results?.weal!!
        } else if (category.equals("前端")) {
            return data.results?.web!!
        }
        return data.results?.android!!
    }

    class GroupViewHolder(itemView: View) : AbstractExpandableItemViewHolder(itemView) {
        fun bindViewHolder(itemData: String) {
            itemView.text1.text = itemData
        }
    }

    class ChildViewHolder(itemView: View) : AbstractExpandableItemViewHolder(itemView) {
        fun bindViewHolder(itemData: DayData.ResultsBean.DataBean) {
            itemView.text2.text = itemData.desc + " by " + itemData.who
        }
    }
}