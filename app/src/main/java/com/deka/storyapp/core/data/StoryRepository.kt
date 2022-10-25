package com.deka.storyapp.core.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.deka.storyapp.core.data.local.UserPreferences
import com.deka.storyapp.core.data.remote.network.ApiService
import com.deka.storyapp.core.data.remote.response.ListStoryResponse
import com.deka.storyapp.core.data.remote.response.LoginResponse
import com.deka.storyapp.core.data.remote.response.RegisterResponse
import com.deka.storyapp.core.data.remote.response.UploadResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

class StoryRepository private constructor(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences)
{

    suspend fun getListStory(token: String, page: Int? = null, size: Int? = null) :
        Flow<Result<ListStoryResponse>> = flow {
        try {
            Log.d("Repo", "Success")
            val response = apiService.getAllStories(token, page, size)
            emit(Result.success(response))
        } catch (e: Exception) {
            Log.d("Repo", "error: ${e.message.toString()} ")
            emit(Result.failure(e))
        }
    }

    suspend fun uploadStory(token: String, file: MultipartBody.Part, description: RequestBody) :
        Flow<Result<UploadResponse>> = flow {
        try {
            Log.d("Repo", "Success")
            val response = apiService.uploadStory(token, file, description)
            emit(Result.success(response))
        } catch (e: Exception) {
            Log.d("Repo", "error: ${e.message.toString()} ")
            emit(Result.failure(e))
        }
    }

    suspend fun register(name: String, email: String, password: String) :
        Flow<Result<RegisterResponse>> = flow{
        try {
            Log.d("Repo", "Success")
            val response = apiService.register(name, email, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            Log.d("Repo", "error: ${e.message.toString()} ")
            emit(Result.failure(e))
        }
    }

    suspend fun login(email: String, password: String) :
        Flow<Result<LoginResponse>> = flow {
        try {
            Log.d("Repo", "Success")
            val response = apiService.login(email, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            Log.d("Repo", "error: ${e.message.toString()} ")
            emit(Result.failure(e))
        }
    }

    suspend fun saveAuthToken(token: String) {
        userPreferences.saveToken(token)
    }

    fun getToken(): Flow<String> = userPreferences.getToken()

}