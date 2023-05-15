package com.capstone.techwastemark01.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.component.DefaultButton
import com.capstone.techwastemark01.ui.component.Hero
import com.capstone.techwastemark01.ui.component.TitledOutlinedTextField
import com.capstone.techwastemark01.ui.componentType.HeroType
import com.capstone.techwastemark01.ui.componentType.OutlinedTextFieldType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
) {
    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

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
                value = fullName,
                onValueChange = { newValue ->
                    fullName = newValue
                },
                outlinedTextFieldType = OutlinedTextFieldType.FullName,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TitledOutlinedTextField(
                value = email,
                onValueChange = { newValue ->
                    email = newValue
                },
                outlinedTextFieldType = OutlinedTextFieldType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            TitledOutlinedTextField(
                value = password,
                onValueChange = { newValue ->
                    password = newValue
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

            Spacer(modifier = Modifier.weight(1f))

            DefaultButton(
                contentText = "Register"
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    TechWasteMark01Theme {
        RegisterScreen()
    }
}