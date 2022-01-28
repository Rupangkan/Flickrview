package com.example.flickview.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickview.data.Flickr
import com.example.flickview.data.Photo
import com.example.flickview.data.Photos
import com.example.flickview.respository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(private val repository: Repository) : ViewModel() {

//    private var FlickrLiveData = MutableLiveData<Flickr>()

    private val _repo = MutableLiveData<Response<Flickr>>(null)
    val repo: LiveData<Response<Flickr>> = _repo

    private val _flickr = MutableLiveData<Flickr>(null)
    val flickr: LiveData<Flickr> = _flickr

    private val _photo = MutableLiveData<Photos>(null)
    val photo: LiveData<Photos> = _photo

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    private val _url = MutableLiveData("")
    val url: LiveData<String>? = _url

    fun get() {
        viewModelScope.launch {
            _repo.value = repository.loadSpecialUsers()
            _flickr.value = repo.value?.body()!!
            _photo.value = flickr.value?.photos
            _photos.value = photo.value?.photo

            Log.d("ViewModel", _photos.value.toString())
        }
//        return repo.toString()
    }

    fun setUrl(url: String){
        _url.value = url
    }


    init {
        get()
    }

}