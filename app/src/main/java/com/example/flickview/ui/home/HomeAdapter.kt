package com.example.flickview.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.flickview.R
import com.example.flickview.data.Flickr

class HomeAdapter(private val model: HomeViewModel, private val ctx: Context): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    //    private val myModel = model
//    private var lastPosition = -1
    class HomeViewHolder(val view: View): RecyclerView.ViewHolder(view){

        val textView: TextView = view.findViewById(R.id.textView2)
        val imageView: ImageView = view.findViewById(R.id.imageView2)
        val cardView: ConstraintLayout = view.findViewById(R.id.card)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_grid_layout, parent, false)

        return HomeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
//        val item = dataset[position]
//        holder.textView.text = ctx.resources.getString(item.stringResourseId)
//        holder.imageView.setImageResource(item.imageResourceId)
//        setAnimation(holder.cardView, position);

    }


    override fun getItemCount() = 20


}