package io.github.xudaojie.gankioforkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder

import io.github.xudaojie.gankioforkotlin.R

/**
 * Created by xdj on 16/9/9.
 */

class TestAdapter : AbstractExpandableItemAdapter<TestAdapter.GroupViewHolder, TestAdapter.ChildViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun getGroupCount(): Int {
        return 10
    }

    override fun getChildCount(groupPosition: Int): Int {
        return 10
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return 0
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_group_item, parent, false)
        return GroupViewHolder(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_child_item, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindGroupViewHolder(holder: GroupViewHolder, groupPosition: Int, viewType: Int) {
        holder.text1.text = "xxx" + groupPosition
    }

    override fun onBindChildViewHolder(holder: ChildViewHolder, groupPosition: Int, childPosition: Int, viewType: Int) {
        holder.text1.text = "xxx" + groupPosition + "x1" + childPosition
    }

    override fun onCheckCanExpandOrCollapseGroup(holder: GroupViewHolder, groupPosition: Int, x: Int, y: Int, expand: Boolean): Boolean {
        return false
    }

    class GroupViewHolder(itemView: View) : AbstractExpandableItemViewHolder(itemView) {

        var text1: TextView

        init {
            text1 = itemView.findViewById(R.id.text1) as TextView
        }
    }

    class ChildViewHolder(itemView: View) : AbstractExpandableItemViewHolder(itemView) {

        var text1: TextView

        init {
            text1 = itemView.findViewById(R.id.text2) as TextView
        }
    }
}
