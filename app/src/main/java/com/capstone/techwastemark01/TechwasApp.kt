package com.capstone.techwastemark01

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.capstone.techwastemark01.ui.navigation.Screen.*
import com.capstone.techwastemark01.ui.screen.login.LoginScreen
import com.capstone.techwastemark01.ui.screen.register.RegisterScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TechwasApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Login.route) {
                LoginScreen(
                    navigateToRegister = {
                        navController.navigate(Register.route)
                    }
                )
            }

            composable(Register.route) {
                RegisterScreen(
                    navigateToLogin = {
                        navController.navigate(Login.route)
                    }
                )
            }
        }
    }
}