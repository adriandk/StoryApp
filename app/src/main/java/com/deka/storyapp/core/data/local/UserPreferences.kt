package com.deka.storyapp.core.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    companion object {
//        @Volatile
//        private var INSTANCE: UserPreferences? = null
//
//        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences {
//            return INSTANCE ?: synchronized(this) {
//                val instance = UserPreferences(dataStore)
//                INSTANCE = instance
//                instance
//            }
//        }

        private val tokenUser = stringPreferencesKey("token")
    }

    fun getToken(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[tokenUser]!!
        }
    }

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[tokenUser] = token
        }
    }

    suspend fun deleteToken() {
        dataStore.edit { preferences ->
            preferences.remove(tokenUser)
        }
    }
}