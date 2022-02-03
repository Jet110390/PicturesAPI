package com.example.picturesapi.viewmodel

import androidx.lifecycle.*
import com.example.picturesapi.models.network.model.Image
import com.example.picturesapi.models.repository.PicRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class PicViewModel (
    private val picRepository: PicRepository
): ViewModel() {
    private var _pics: MutableLiveData<List<Image>?> = MutableLiveData()
    val pics: LiveData<List<Image>?> = _pics


    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val response = picRepository.getPhotos()
            _pics.postValue(response)
        }
    }
    class Factory(
        private val picRepository: PicRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PicViewModel::class.java)) {
                return PicViewModel(picRepository) as T
            } else{
                throw RuntimeException("Could not create instance of PicViewModel")
            }
        }
    }
}