package com.example.flickview.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.flickview.data.Flickr
import com.example.flickview.data.Photo
import javax.inject.Inject
import android.R
import android.text.Layout
import android.util.Log
import androidx.core.view.get
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions




class HomeAdapter(val homeViewModel: HomeViewModel, private val ctx: Context, /*private val dataset: List<Photo>*/): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

//    private val dataset = homeViewModel.photos.value
    var dataset: List<Photo>? = null
    inner class HomeViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(com.example.flickview.R.id.imageView2)
        val cardView: ConstraintLayout = view.findViewById(com.example.flickview.R.id.card)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(com.example.flickview.R.layout.custom_grid_layout, parent, false)
        homeViewModel.apply {
            get()
            dataset = photos.value
        }
        return HomeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
//        homeViewModel.apply {
//            get()
//            holder.dataset = photos?.value
//        }
        Log.d("Adapter", dataset.toString())

        val item = dataset?.get(position)?.url_s
        val title = dataset?.get(position)?.title
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(com.example.flickview.R.drawable.ic_launcher_foreground)
            .error(com.example.flickview.R.drawable.ic_launcher_foreground)

        Glide.with(ctx)
            .load(item)
            .apply(options)
            .into(holder.imageView)

        holder.imageView.setOnClickListener{
            if (item != null && title!=null) {
                homeViewModel.apply {
                    setUrl(item)
                    setTitle(title)
                }
            }
            val action: NavDirections = HomeFragmentDirections.actionNavHomeToViewImage()
            holder.imageView.findNavController().navigate(action)
        }

//        holder.textView.text = ctx.resources.getString(item.stringResourseId)
//        holder.imageView.setImageResource(item.imageResourceId)

//        setAnimation(holder.cardView, position);

    }


//    override fun getItemCount(): Int {
//        if(dataset!=null){
//            return dataset.size
//        }else{
//            return 20
//        }
//    }

    override fun getItemCount() = 20



}