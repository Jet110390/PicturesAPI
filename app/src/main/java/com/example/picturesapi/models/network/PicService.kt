package com.example.picturesapi.models.network

import com.example.picturesapi.models.network.model.Image
import retrofit2.Response
import retrofit2.http.GET

interface PicService {

    @GET("photos")
    suspend fun getPhotos(): Response<List<Image>>
}