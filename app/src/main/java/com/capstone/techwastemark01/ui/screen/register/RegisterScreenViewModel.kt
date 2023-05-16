package com.capstone.techwastemark01.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.techwastemark01.data.model.UserRegisterInfo
import com.capstone.techwastemark01.repository.TechwasUserApiRepository
import com.capstone.techwastemark01.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val userApiRepository: TechwasUserApiRepository
) : ViewModel() {

    private val _userToRegisterState: MutableStateFlow<UiState<String>?> = MutableStateFlow(null)
    val userToRegisterState = _userToRegisterState.asStateFlow()

    private val _userToRegisterInfo: MutableStateFlow<UserRegisterInfo> = MutableStateFlow(
        UserRegisterInfo(
            fullname = "",
            email = "",
            password = ""
        )
    )
    val userToRegisterInfo = _userToRegisterInfo.asStateFlow()

    fun registerUser() {

        _userToRegisterState.value = UiState.Loading()
        viewModelScope.launch {

            _userToRegisterState.value = userApiRepository.userRegister(_userToRegisterInfo.value)

        }
    }

    fun updateUserToRegisterInfo(userToRegisterInfo: UserRegisterInfo) {
        _userToRegisterInfo.value = userToRegisterInfo
    }

}