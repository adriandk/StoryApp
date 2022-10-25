package com.deka.storyapp.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deka.storyapp.core.data.StoryRepository
import com.deka.storyapp.core.data.remote.response.ListStoryResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val storyRepository: StoryRepository) : ViewModel() {

    suspend fun getAllStories(token: String): Flow<Result<ListStoryResponse>> =
        storyRepository.getListStory(token, null, null)

    fun saveAuthToken(token: String) {
        viewModelScope.launch {
            storyRepository.saveAuthToken(token)
        }
    }
}