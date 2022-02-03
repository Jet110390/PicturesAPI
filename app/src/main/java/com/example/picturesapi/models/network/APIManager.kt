package com.example.picturesapi.models.network

class APIManager {

    private var picService: PicService =
        RetrofitInstance.providesRetrofit().create(PicService::class.java)

    suspend fun getPhotos() = picService.getPhotos()
}