package com.capstone.techwastemark01.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.techwastemark01.ui.componentType.BottomNavItemType
import com.capstone.techwastemark01.ui.helper.BottomNavShape
import com.capstone.techwastemark01.ui.theme.TechWasteMark01Theme

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .graphicsLayer {
                shape = BottomNavShape()
                clip = true
            }
            .background(MaterialTheme.colorScheme.inverseSurface)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 27.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(1f)
            ) {
                BottomNavigationItem(
                    itemType = BottomNavItemType.Home,
                    selected = true
                )
                BottomNavigationItem(
                    itemType = BottomNavItemType.Forum,
                    selected = false
                )
            }
            Spacer(modifier = Modifier.width(142.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(1f)
            ) {
                BottomNavigationItem(
                    itemType = BottomNavItemType.Article,
                    selected = false
                )
                BottomNavigationItem(
                    itemType = BottomNavItemType.Profile,
                    selected = false
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            BottomNavigation()
        }
    }
}

@Composable
fun BottomNavigationItem(
    itemType: BottomNavItemType,
    selected: Boolean
) {
    Column(
        modifier = Modifier.height(44.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = itemType.icon),
            contentDescription = null,
            tint = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inverseOnSurface
        )
        Text(
            text = itemType.title,
            style = MaterialTheme.typography.labelSmall,
            color = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inverseOnSurface
        )
    }
}

@Preview
@Composable
fun BottomNavigationItemPreview() {
    TechWasteMark01Theme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseSurface)
                .padding(20.dp)
        ) {
            BottomNavigationItem(
                itemType = BottomNavItemType.Home,
                selected = false
            )
        }
    }
    
}