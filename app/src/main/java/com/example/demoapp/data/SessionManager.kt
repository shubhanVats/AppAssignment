package com.example.demoapp.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Session manager to save and fetch data from SharedPreferences
 */


private const val DATA_STORE_NAME = "wakeMate"
private val Context.dataStore by preferencesDataStore(DATA_STORE_NAME)

class SessionManager(private val context: Context) {

    val dataStore = context.dataStore

    companion object {
        val USER_TOKEN = stringPreferencesKey("user_token")
        val USER_ID = stringPreferencesKey("user_id")
        val IS_VERIFIED = booleanPreferencesKey("is_verified")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_NAME = stringPreferencesKey("user_name")
        val FORCE_PASSWORD_CHANGE = booleanPreferencesKey("force_password_change")
    }


    /**
     * Function to save auth token
     */

    /**
     * Function to save auth token
     */

    val authToken: Flow<String>
        get() = dataStore.data.map {
            it[USER_TOKEN] ?: ""
        }

    suspend fun saveAuthToken(token: String) {
        dataStore.edit {
            it[USER_TOKEN] = token
        }
    }

    val isVerified: Flow<Boolean>
        get() = dataStore.data.map {
            it[IS_VERIFIED] ?: false
        }

    suspend fun setIsVerified(isVerified: Boolean) {
        dataStore.edit {
            it[IS_VERIFIED] = isVerified
        }
    }

    val forcePasswordChange: Flow<Boolean>
        get() = dataStore.data.map {
            it[FORCE_PASSWORD_CHANGE] ?: false
        }

    suspend fun setForcePasswordChange(forcePasswordChange: Boolean) {
        dataStore.edit {
            it[FORCE_PASSWORD_CHANGE] = forcePasswordChange
        }
    }

    val userId: Flow<String>
        get() = dataStore.data.map {
            it[USER_ID] ?: ""
        }

    suspend fun setUserId(userId: String) {
        dataStore.edit {
            it[USER_ID] = userId
        }
    }

    val userEmail: Flow<String>
        get() = dataStore.data.map {
            it[USER_EMAIL] ?: ""
        }

    suspend fun setUserEmail(userEmail: String) {
        dataStore.edit {
            it[USER_EMAIL] = userEmail
        }
    }

    val userName: Flow<String>
        get() = dataStore.data.map {
            it[USER_NAME] ?: ""
        }

    suspend fun setUserName(userName: String) {
        dataStore.edit {
            it[USER_NAME] = userName
        }
    }

    suspend fun deleteAuthToken() {
        dataStore.edit {
            it.remove(USER_TOKEN)
        }
    }

    suspend fun deleteSession() {
        dataStore.edit {
            it.clear()
        }
    }
}