package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.componentType.OutlinedTextFieldType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitledOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    outlinedTextFieldType: OutlinedTextFieldType,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colorScheme.secondary,
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            placeholderColor = MaterialTheme.colorScheme.secondary,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.secondary,
                backgroundColor = MaterialTheme.colorScheme.background
            ),
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,

        ),
        singleLine = true,
        label = {
            Text(
                text = outlinedTextFieldType.labelText,
                style = MaterialTheme.typography.labelLarge,
            )
        },
        placeholder = {
            Text(
                text = outlinedTextFieldType.placeHolderText,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .alpha(0.7f)
            )
        },
        shape = MaterialTheme.shapes.small,
        textStyle = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TitledOutlinedTextFieldPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            TitledOutlinedTextField(
                value = "tewas@gmail.com",
                onValueChange = {},
                outlinedTextFieldType = OutlinedTextFieldType.FullName
            )
        }
    }
}