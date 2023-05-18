package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.capstone.techwastemark01.ui.theme.Grey10
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onNavigationClick: () -> Unit,
    onActionClick: () -> Unit,
    borderColor: Color,
    circleColor: Color
) {
    TopAppBar(
        title = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = title,
                    color = Grey10,
                    fontSize = 16.sp,
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick,
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary)
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Canvas(modifier = Modifier.size(24.dp)) {
                    drawCircle(
                        color = circleColor,
                        center = Offset(size.width / 2, size.height / 2),
                        radius = size.minDimension / 2
                    )
                    drawIntoCanvas { canvas ->
                        val text = "?"
                        val textPaint = android.graphics.Paint().apply {
                            color = android.graphics.Color.WHITE
                            textSize = 14.sp.toPx()
                            textAlign = android.graphics.Paint.Align.CENTER
                        }
                        val textOffset = Offset(
                            x = size.width / 2,
                            y = size.height / 2 - (textPaint.ascent() + textPaint.descent()) / 2
                        )
                        canvas.nativeCanvas.drawText(text, textOffset.x, textOffset.y, textPaint)
                    }
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
        modifier = Modifier
            .drawWithContent {
            drawContent()
            drawLine(
                color = borderColor,
                start = Offset(0f, size.height - 1.dp.toPx()),
                end = Offset(size.width, size.height - 1.dp.toPx()),
                strokeWidth = 1.dp.toPx()
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            AppTopBar(
                title = "Prediksi E-Waste",
                onNavigationClick = { /* TODO */ },
                onActionClick = { /*TODO*/ },
                borderColor = MaterialTheme.colorScheme.primary,
                circleColor = MaterialTheme.colorScheme.primary
            )
        }
    }
}
