package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.componentType.HeroType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun Hero(
    modifier: Modifier = Modifier,
    heroType: HeroType
) {
    val circleColor = MaterialTheme.colorScheme.tertiary

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clipToBounds()
            .drawBehind {
                drawCircle(
                    color = circleColor,
                    radius = (size.width - 238),
                    center = Offset(
                        x = (size.width - (size.width - 238)),
                        y = 0f
                    )
                )
            }
            .padding(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Text(
                text = heroType.titleText,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = heroType.subtitleText,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            Hero(
                heroType = HeroType.Register
            )
        }
    }
}