package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun Banner() {
    val circleColor = MaterialTheme.colorScheme.background

    Box(
        modifier = Modifier
            .height(150.dp)
            .clip(MaterialTheme.shapes.large)
            .clipToBounds()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .drawBehind {
                drawCircle(
                    color = circleColor,
                    center = Offset(
                        x = size.width - (25.dp).toPx(),
                        y = size.height - (19.dp).toPx()
                    ),
                    radius = 62.dp.toPx(),
                    style = Stroke(
                        width = 30.dp.toPx()
                    )
                )
            }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(215.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Take your trash and make money",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun BannerPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            Banner()
        }
    }
}