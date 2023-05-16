package com.capstone.techwastemark01.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.techwastemark01.data.model.UserLoginInfo
import com.capstone.techwastemark01.repository.TechwasUserApiRepository
import com.capstone.techwastemark01.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val userApiRepository: TechwasUserApiRepository
) : ViewModel() {

    private val _userToLoginState: MutableStateFlow<UiState<String>?> = MutableStateFlow(null)
    val userToLoginState = _userToLoginState.asStateFlow()

    private val _userToLoginInfo: MutableStateFlow<UserLoginInfo> = MutableStateFlow(
        UserLoginInfo(
            email = "",
            password = ""
        )
    )
    val userToLoginInfo = _userToLoginInfo.asStateFlow()

    fun loginUser() {

        _userToLoginState.value = UiState.Loading()
        viewModelScope.launch {

            _userToLoginState.value = userApiRepository.userLogin(_userToLoginInfo.value)

        }
    }

    fun updateUserLoginInfo(userToLoginInfo: UserLoginInfo) {
        _userToLoginInfo.value = userToLoginInfo
    }

}