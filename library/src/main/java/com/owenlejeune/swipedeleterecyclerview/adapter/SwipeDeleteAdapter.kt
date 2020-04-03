package com.owenlejeune.swipedeleterecyclerview.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class SwipeDeleteAdapter<T, VH: RecyclerView.ViewHolder>(val items: MutableList<T>): RecyclerView.Adapter<VH>() {

    open fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

}
