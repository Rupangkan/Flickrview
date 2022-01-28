package com.example.flickview.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.flickview.databinding.FragmentHomeBinding
import com.example.flickview.databinding.FragmentViewImageBinding
import com.example.flickview.ui.home.HomeAdapter
import com.example.flickview.ui.home.HomeViewModel

class ViewImage: Fragment() {
    //    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentViewImageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentViewImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewFragment = this

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(com.example.flickview.R.drawable.ic_launcher_foreground)
            .error(com.example.flickview.R.drawable.ic_launcher_foreground)

        Glide.with(this)
            .load(homeViewModel.url?.value)
            .apply(options)
            .into(binding.imageView)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}