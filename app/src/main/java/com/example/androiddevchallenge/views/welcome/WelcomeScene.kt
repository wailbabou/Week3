package com.example.androiddevchallenge.views.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScene(navigateToLogin :() -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Box{
            // background
            Image(
                painter = painterResource(id = R.drawable.ic_welcome),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            // content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
                    .padding(16.dp),

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(16.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(Modifier.size(32.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth()
                    ,
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                ) {
                    Text(
                        text = "Sign up".toUpperCase(),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Spacer(Modifier.size(8.dp))
                Button(
                    onClick = { navigateToLogin() },
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth()
                    ,
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Log in".toUpperCase(),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}

@Preview("Light Welcome", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview(){
    MyTheme {
        WelcomeScene(navigateToLogin = { /*TODO*/ })
    }
}
@Preview("Dark Welcome", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview(){
    MyTheme(darkTheme = true) {
        WelcomeScene(navigateToLogin = { /*TODO*/ })
    }
}
