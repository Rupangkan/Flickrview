package com.example.flickview.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.util.LogTime
import com.example.flickview.data.Flickr
import com.example.flickview.data.Photo
import com.example.flickview.databinding.FragmentHomeBinding
import com.example.flickview.network.RetrofitClientInstance
//import com.example.flickview.network.RetrofitClientInstance
import com.example.flickview.network.RetrofitInterface
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

@AndroidEntryPoint
class HomeFragment : Fragment() {

//    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
//    private val retrofitInstance = RetrofitClientInstance.retrofitInstance?.create(RetrofitInterface::class.java)

    private val homeViewModel: HomeViewModel by activityViewModels()
//    private val photos: List<Photo> = sharedViewModel.photos.value!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
//        homeViewModel =
//            ViewModelProvider(this)[HomeViewModel::class.java]

        recyclerView = binding.dataList
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        val adapter = context?.let { HomeAdapter( homeViewModel, it ) }
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}