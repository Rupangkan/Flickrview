package com.example.flickview.respository

import com.example.flickview.network.RetrofitInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


class Repository(private val apiService: RetrofitInterface) {
    suspend fun loadSpecialUsers() = apiService.loadSpecialUsers("?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
}