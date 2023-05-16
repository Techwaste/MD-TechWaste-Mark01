package com.capstone.techwastemark01.repository

import com.capstone.techwastemark01.data.model.UserLoginInfo
import com.capstone.techwastemark01.data.model.UserRegisterInfo
import com.capstone.techwastemark01.data.remote.apiService.TechwasUserApi
import com.capstone.techwastemark01.ui.common.UiState
import java.lang.Exception
import javax.inject.Inject

class TechwasUserApiRepository @Inject constructor(
    private val userApi: TechwasUserApi
) {

    suspend fun userLogin(userLoginInfo: UserLoginInfo) : UiState<String> {

        val response = try {
            userApi.login(userLoginInfo)
        } catch (e: Exception) {
            return UiState.Error(message = e.message ?: "Fail to authenticate user")
        }
        return UiState.Success(data = response)
    }

    suspend fun userRegister(userRegisterInfo: UserRegisterInfo) : UiState<String> {

        val response = try {
            userApi.register(userRegisterInfo)
        } catch (e: Exception) {
            return UiState.Error(message = e.message ?: "Fail to create user")
        }
        return UiState.Success(data = response)
    }

}