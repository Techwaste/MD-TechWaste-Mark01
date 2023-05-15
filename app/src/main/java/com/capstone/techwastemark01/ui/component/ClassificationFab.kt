package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.R
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun ClassificationFab(
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = {},
        shape = MaterialTheme.shapes.extraLarge,
        containerColor = MaterialTheme.colorScheme.primary,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 12.dp
        ),
        modifier = modifier.size(63.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_camera),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClassificationPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            ClassificationFab()
        }
    }
}