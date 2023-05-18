package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.theme.Sakura68
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun DefaultOutlinedButton(
    modifier: Modifier = Modifier,
    contentText: String = "Button"
) {
    OutlinedButton(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = Color.Transparent,
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = contentText,
            style = MaterialTheme.typography.titleMedium,
            color = Sakura68,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultOutlinedButtonPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            DefaultOutlinedButton()
        }
    }
}