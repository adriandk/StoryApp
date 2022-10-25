package com.deka.storyapp.core.viewmodel

import androidx.lifecycle.ViewModel
import com.deka.storyapp.core.data.StoryRepository
import com.deka.storyapp.core.data.remote.response.UploadResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

class UploadViewModel(private val storyRepository: StoryRepository) : ViewModel() {

    suspend fun uploadImage(token: String, file: MultipartBody.Part, description: RequestBody): Flow<Result<UploadResponse>> =
        storyRepository.uploadStory(token, file, description)

    fun getToken(): Flow<String?> = storyRepository.getToken()

}