package com.capstone.techwastemark01.ui.helper

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class BottomNavShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {

                val widthInDp = with(density) { size.width.toDp() }
                val leftCircleStartPx = with(density) {
                    (widthInDp/2 - 42.dp).toPx()
                }
                val leftCircleEndPx = with(density) {
                    (widthInDp/2 + 2.dp).toPx()
                }
                val rightCircleStartPx = with(density) {
                    (widthInDp/2 - 2.dp).toPx()
                }
                val rightCircleEndPx = with(density) {
                    (widthInDp/2 + 42.dp).toPx()
                }
                val centerGapEnd = with(density) {
                    (widthInDp/2 + 20.dp).toPx()
                }
                val circleRect = with(density) { 22.dp.toPx() }


                moveTo(0f, 0f)
                lineTo(
                    x = leftCircleStartPx,
                    y = 0f
                )
                arcTo(
                    rect = Rect(
                        topLeft = Offset(
                            x = leftCircleStartPx,
                            y = -circleRect
                        ),
                        bottomRight = Offset(
                            x = leftCircleEndPx,
                            y = circleRect
                        )
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )
                lineTo(
                    x = centerGapEnd,
                    y = circleRect
                )
                arcTo(
                    rect = Rect(
                        topLeft = Offset(
                            x = rightCircleStartPx,
                            y = -circleRect
                        ),
                        bottomRight = Offset(
                            x = rightCircleEndPx,
                            y = circleRect
                        )
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
            }
        )
    }
}