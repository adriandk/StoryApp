package com.deka.storyapp.core.viewmodel

import androidx.lifecycle.ViewModel
import com.deka.storyapp.core.data.StoryRepository

class RegisterViewModel(private val storyRepository: StoryRepository) : ViewModel() {

    suspend fun userRegister(name: String, email: String, password: String) {
        storyRepository.register(name, email, password)
    }
}