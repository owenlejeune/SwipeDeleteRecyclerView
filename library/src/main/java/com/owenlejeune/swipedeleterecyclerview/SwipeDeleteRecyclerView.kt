package com.owenlejeune.swipedeleterecyclerview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.owenlejeune.swipedeleterecyclerview.adapter.SwipeDeleteAdapter
import com.owenlejeune.swipedeleterecyclerview.callback.SwipeToDeleteCallback

class SwipeDeleteRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RecyclerView(context, attrs, defStyleAttr) {

    private val swipeCallback = object: SwipeToDeleteCallback(context) {
        override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
            val adapter = adapter as SwipeDeleteAdapter<*,*>
            adapter.removeAt(viewHolder.adapterPosition)
        }
    }

    init {
        layoutManager = LinearLayoutManager(context)
        context.theme.obtainStyledAttributes(attrs, R.styleable.SwipeDeleteRecyclerView, 0, 0)
            .apply { swipeCallback.applyAttrs(this) }
        val itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(this)
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        Log.w("SwipeDeleteRecyclerView", "Use setSwipeAdapter() instead")
        // do nothing
    }

    override fun swapAdapter(adapter: Adapter<*>?, removeAndRecycleExistingViews: Boolean) {
        Log.w("SwipeDeleteRecyclerView", "Use swapSwipeAdapter() instead")
        // do nothing
    }

    fun setSwipeAdapter(adapter: SwipeDeleteAdapter<*,*>) {
        super.setAdapter(adapter)
    }

    fun swapSwipeAdapter(adapter: SwipeDeleteAdapter<*,*>, removeAndRecycleExistingViews: Boolean) {
        super.swapAdapter(adapter, removeAndRecycleExistingViews)
    }

}