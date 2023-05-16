package com.capstone.techwastemark01.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.capstone.techwastemark01.data.model.UserLoginInfo
import com.capstone.techwastemark01.ui.common.UiState
import com.capstone.techwastemark01.ui.component.DefaultButton
import com.capstone.techwastemark01.ui.component.Hero
import com.capstone.techwastemark01.ui.component.TitledOutlinedTextField
import com.capstone.techwastemark01.ui.componentType.HeroType
import com.capstone.techwastemark01.ui.componentType.OutlinedTextFieldType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginScreenViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit
) {
    val userToLoginState by viewModel.userToLoginState.collectAsState()
    val userToLoginInfo by viewModel.userToLoginInfo.collectAsState()

    LoginScreenContent(
        modifier = modifier,
        navigateToRegister = navigateToRegister,
        userToLoginInfo = userToLoginInfo,
        updateUserToLoginInfo = { viewModel.updateUserLoginInfo(it) },
        userToLoginState = userToLoginState,
        loginUser = { viewModel.loginUser() }
    )
}

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    navigateToRegister: () -> Unit,
    userToLoginInfo: UserLoginInfo,
    updateUserToLoginInfo: (UserLoginInfo) -> Unit,
    userToLoginState: UiState<String>?,
    loginUser: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Hero(heroType = HeroType.Login)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp, bottom = 50.dp)
        ) {
            TitledOutlinedTextField(
                value = userToLoginInfo.email,
                onValueChange = { newValue ->
                    updateUserToLoginInfo(userToLoginInfo.copy(
                        email = newValue
                    ))
                },
                outlinedTextFieldType = OutlinedTextFieldType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TitledOutlinedTextField(
                value = userToLoginInfo.password,
                onValueChange = { newValue ->
                    updateUserToLoginInfo(userToLoginInfo.copy(
                        password = newValue
                    ))
                },
                outlinedTextFieldType = OutlinedTextFieldType.Password,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Forgot Password?",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            if(userToLoginState != null) {
                when(userToLoginState) {
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
                            userToLoginState.data?.let { Text(text = it) }
                        }
                    }
                    is UiState.Error -> {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            userToLoginState.message?.let { Text(text = it) }
                        }
                    }
                }
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }

            DefaultButton(
                contentText = "Login",
                onClick = loginUser
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Don't have account?",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { navigateToRegister() }
                )

            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreviewNull() {
    TechWasteMark01Theme {
        LoginScreenContent(
            navigateToRegister = {},
            userToLoginState = null,
            userToLoginInfo = UserLoginInfo("", ""),
            updateUserToLoginInfo = {},
            loginUser = {}
        )
    }
}

@Preview
@Composable
fun LoginScreenPreviewLoading() {
    TechWasteMark01Theme {
        LoginScreenContent(
            navigateToRegister = {},
            userToLoginState = UiState.Loading(),
            userToLoginInfo = UserLoginInfo("", ""),
            updateUserToLoginInfo = {},
            loginUser = {}
        )
    }
}