package com.capstone.techwastemark01.ui.componentType

sealed class HeroType(val titleText: String, val subtitleText: String) {
    object Login: HeroType(titleText = "Sign in to your account", subtitleText = "Welcome Back!")
    object Register: HeroType(titleText = "Register", subtitleText = "Create your account")
}
