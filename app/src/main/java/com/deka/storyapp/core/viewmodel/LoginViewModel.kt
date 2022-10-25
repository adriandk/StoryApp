package com.deka.storyapp.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deka.storyapp.core.data.StoryRepository
import kotlinx.coroutines.launch

class LoginViewModel (private val storyRepository: StoryRepository) : ViewModel() {

    suspend fun userLogin(email: String, password: String) {
        storyRepository.login(email, password)
    }

    fun saveAuthToken(token: String) {
        viewModelScope.launch {
            storyRepository.saveAuthToken(token)
        }
    }
}