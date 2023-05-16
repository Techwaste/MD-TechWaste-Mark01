package com.capstone.techwastemark01.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.component.ArticleCardBig
import com.capstone.techwastemark01.ui.component.ArticleFilterItem
import com.capstone.techwastemark01.ui.component.Banner
import com.capstone.techwastemark01.ui.component.BottomNavigation
import com.capstone.techwastemark01.ui.component.ClassificationFab
import com.capstone.techwastemark01.ui.component.GreetUser
import com.capstone.techwastemark01.ui.componentType.ArticleFilterType
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
) {
    val filterTypeList = listOf(
        ArticleFilterType.General,
        ArticleFilterType.Laptop,
        ArticleFilterType.Tv,
        ArticleFilterType.LightBulb,
        ArticleFilterType.Battery,
        ArticleFilterType.Cable
    )

    Scaffold(
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    GreetUser()
                    Spacer(modifier = Modifier.height(24.dp))
                    Banner()
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Artikel Terkini",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
//                modifier = Modifier.padding(start = 20.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp)
                ) {
                    items(
                        items = filterTypeList,
                    ) { filter ->
                        ArticleFilterItem(
                            filterType = filter,
                            selected = false
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 78.dp)
                ) {
                    items(5) { article ->
                        ArticleCardBig()
                    }
                }
            }
            BottomNavigation()
            ClassificationFab(
                modifier = Modifier.padding(bottom = 46.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    TechWasteMark01Theme {
        HomeScreen()
    }
}