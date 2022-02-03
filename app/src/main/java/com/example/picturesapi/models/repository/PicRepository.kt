package com.example.picturesapi.models.repository

import com.example.picturesapi.models.network.APIManager
import com.example.picturesapi.models.network.model.Image
import java.lang.Exception

class PicRepository (
    private val apiManager: APIManager
) {
    suspend fun getPhotos(): List<Image>? {
        return try {
            val response = apiManager.getPhotos()
            if (response.isSuccessful) {
                response.body()
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }
}