package com.capstone.techwastemark01.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.component.AppTopBar
import com.capstone.techwastemark01.ui.component.ArticleFilterItem
import com.capstone.techwastemark01.ui.componentType.ArticleFilterType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickEwasteScreen(
    modifier: Modifier = Modifier,
) {
    val filterTypeList = listOf(
        ArticleFilterType.General,
        ArticleFilterType.Laptop,
        ArticleFilterType.Tv,
        ArticleFilterType.LightBulb,
        ArticleFilterType.Battery,
        ArticleFilterType.Cable,
        ArticleFilterType.LightBulb,
        ArticleFilterType.Battery,
        ArticleFilterType.Cable,
        ArticleFilterType.LightBulb,
        ArticleFilterType.Battery,
        ArticleFilterType.Cable
    )

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Pilih E-Waste",
                onNavigationClick = { /*TODO*/ },
                onActionClick = { /*TODO*/ },
                borderColor = MaterialTheme.colorScheme.primary,
                circleColor = MaterialTheme.colorScheme.primary,
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            Column{
                LazyVerticalGrid(
                    columns = GridCells.Fixed(5),
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    items(filterTypeList) { filter ->
                        ArticleFilterItem(
                            filterType = filter,
                            selected = true,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PickEwasteScreenPreview() {
    TechWasteMark01Theme {
        PickEwasteScreen()
    }
}