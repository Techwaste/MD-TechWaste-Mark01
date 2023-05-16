package com.capstone.techwastemark01.ui.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.capstone.techwastemark01.data.model.UserRegisterInfo
import com.capstone.techwastemark01.ui.common.UiState
import com.capstone.techwastemark01.ui.component.DefaultButton
import com.capstone.techwastemark01.ui.component.Hero
import com.capstone.techwastemark01.ui.component.TitledOutlinedTextField
import com.capstone.techwastemark01.ui.componentType.HeroType
import com.capstone.techwastemark01.ui.componentType.OutlinedTextFieldType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterScreenViewModel = hiltViewModel(),
    navigateToLogin:  () -> Unit
) {
    val userToRegisterState by viewModel.userToRegisterState.collectAsState()
    val userToRegisterInfo by viewModel.userToRegisterInfo.collectAsState()

    RegisterScreenContent(
        modifier = modifier,
        navigateToLogin = navigateToLogin,
        userToRegisterInfo = userToRegisterInfo,
        updateUserToRegisterInfo = { viewModel.updateUserToRegisterInfo(it) },
        userToRegisterState = userToRegisterState,
        registerUser = { viewModel.registerUser() }
    )
}

@Composable
fun RegisterScreenContent(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    userToRegisterInfo: UserRegisterInfo,
    updateUserToRegisterInfo: (UserRegisterInfo) -> Unit,
    userToRegisterState: UiState<String>?,
    registerUser: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Hero(heroType = HeroType.Register)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp, bottom = 50.dp)
        ) {
            TitledOutlinedTextField(
                value = userToRegisterInfo.fullname,
                onValueChange = { newValue ->
                    updateUserToRegisterInfo(userToRegisterInfo.copy(
                        fullname = newValue
                    ))
                },
                outlinedTextFieldType = OutlinedTextFieldType.FullName,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TitledOutlinedTextField(
                value = userToRegisterInfo.email,
                onValueChange = { newValue ->
                    updateUserToRegisterInfo(userToRegisterInfo.copy(
                        email = newValue
                    ))
                },
                outlinedTextFieldType = OutlinedTextFieldType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TitledOutlinedTextField(
                value = userToRegisterInfo.password,
                onValueChange = { newValue ->
                    updateUserToRegisterInfo(userToRegisterInfo.copy(
                        password = newValue
                    ))
                },
                outlinedTextFieldType = OutlinedTextFieldType.Password,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "User agreement to register.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Read here",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                )
            }

            if(userToRegisterState != null) {
                when(userToRegisterState) {
                    is UiState.Loading -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                    is UiState.Success -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            userToRegisterState.data?.let { Text(text = it) }
                        }
                    }
                    is UiState.Error -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            userToRegisterState.message?.let { Text(text = it) }
                        }
                    }
                }
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }

            DefaultButton(
                contentText = "Register",
                onClick = registerUser
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    TechWasteMark01Theme {
        RegisterScreenContent(
            navigateToLogin = {},
            userToRegisterInfo = UserRegisterInfo("", "", ""),
            updateUserToRegisterInfo = {},
            userToRegisterState = null,
            registerUser = {}
        )
    }
}