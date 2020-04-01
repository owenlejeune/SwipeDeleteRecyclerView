package com.owenlejeune.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.owenlejeune.swipedeleterecyclerview.SwipeDeleteRecyclerView
import com.owenlejeune.swipedeleterecyclerview.adapter.SwipeDeleteAdapter

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<String>()

    init {
        for (i in 0..20) {
            list.add("Item ${i}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<SwipeDeleteRecyclerView>(R.id.recyclerview)
        recyclerView.setSwipeAdapter(MySwipeDeleteAdapter(list))
    }

    inner class MySwipeDeleteAdapter(items: MutableList<String>): SwipeDeleteAdapter<String, MySwipeDeleteAdapter.ViewHolder>(items) {

        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val view = holder.itemView

            val itemView = view.findViewById<AppCompatTextView>(R.id.item_view)
            itemView.text = items[position]
        }

    }
}
