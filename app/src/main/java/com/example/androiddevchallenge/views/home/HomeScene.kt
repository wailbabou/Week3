package com.example.androiddevchallenge.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.CardModel

@Composable
fun HomeScene(homeViewModel: HomeViewModel = HomeViewModel()){
    val search : String by homeViewModel.search.observeAsState("")
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    shape = CircleShape,
                    onClick = {},
                    backgroundColor = MaterialTheme.colors.primary
                ){
                    Icon(Icons.Filled.PlayArrow,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            } ,
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true ,
            bottomBar = {
                BottomNavigation(
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    class Nav(val title: String, val resource: ImageVector)

                    val navs = listOf(
                        Nav("Home", Icons.Filled.Spa),
                        Nav("Profile", Icons.Filled.AccountCircle)
                        )
                    var selected by remember { mutableStateOf(0) }
                    navs.forEachIndexed { index, nav ->
                        BottomNavigationItem(
                            selected = selected == index,
                            label = {
                                Text(
                                    text = nav.title.toUpperCase(),
                                    style = MaterialTheme.typography.caption,
                                    color = MaterialTheme.colors.onBackground
                                )
                            },
                            icon = {
                                Icon(nav.resource,
                                    contentDescription = nav.title,
                                    modifier = Modifier.size(18.dp)
                                )
                            },
                            onClick = {
                                selected = index
                            }
                        )
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(56.dp))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                    ,
                    value = search,
                    onValueChange = { homeViewModel.onSearchChanged(it)},
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            tint = MaterialTheme.colors.onBackground,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    label = { Text(
                        text="Search",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )}
                )

                Text(
                    text = "Favorite Collections".toUpperCase(),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    itemsIndexed(homeViewModel.itemsFavorite){ index, _ ->
                        if (index % 2 == 0 ){
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                FavoriteRow(item = homeViewModel.itemsFavorite[index])
                                FavoriteRow(item = homeViewModel.itemsFavorite[index+1])
                            }
                        }
                    }
                }

                Text(
                    text = "Align your body".toUpperCase(),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(homeViewModel.itemsBody){ content ->
                        BodyRow(item = content)
                    }
                }
                Text(
                    text = "Align your mind".toUpperCase(),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.paddingFromBaseline(top = 42.dp, bottom = 8.dp)
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(homeViewModel.itemsMind){ content ->
                        BodyRow(item = content)
                    }
                }
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun FavoriteRow(item : CardModel){
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .size(192.dp, 56.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            Modifier.background(MaterialTheme.colors.surface)
        ) {
            Image(
                modifier = Modifier
                    .size(56.dp, 56.dp),
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.text,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentSize(align = Alignment.Center)
            )

        }
    }
}
@Composable
fun BodyRow(item:CardModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            elevation = 0.dp,
            modifier = Modifier
                .size(88.dp)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }

        Text(
            text = item.text,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
    }
}

@Preview("Light Home", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview(){
    MyTheme {
        HomeScene()
    }
}
@Preview("Dark Home", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview(){
    MyTheme(darkTheme = true) {
        HomeScene()
    }
}
