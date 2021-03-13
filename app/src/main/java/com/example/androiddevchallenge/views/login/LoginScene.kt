package com.example.androiddevchallenge.views.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.androiddevchallenge.R

@Composable
fun LoginScene(loginViewModel: LoginViewModel = LoginViewModel(), navigateToHome : () -> Unit ){

    val email : String by loginViewModel.email.observeAsState("")
    val password : String by loginViewModel.password.observeAsState("")

    Surface(color = MaterialTheme.colors.background) {
        Box{
            // background
            Image(
                painter = painterResource(id = R.drawable.ic_login),
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
                Text(
                    text = "Log in".toUpperCase(),
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .paddingFromBaseline(bottom = 32.dp)

                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                    ,
                    value = email,
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    onValueChange = { loginViewModel.onEmailChanged(it)},
                    label = { Text(
                        text="Email",
                        style = MaterialTheme.typography.body1
                    ) }
                )
                Spacer(Modifier.size(8.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                    ,
                    value = password,
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                    onValueChange = { loginViewModel.onPasswordChanged(it)},
                    label = { Text(
                        text="Password",
                        style = MaterialTheme.typography.body1
                    ) }
                )
                Spacer(Modifier.size(8.dp))
                Button(
                    onClick = { navigateToHome() },
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth()
                    ,
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                ) {
                    Text(
                        text = "Log in".toUpperCase(),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Text(
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp)
                        .fillMaxWidth(),
                    text = buildAnnotatedString {
                        append("Don't have an account? ")
                        append(
                            AnnotatedString(
                                "Sign up",
                                SpanStyle(textDecoration = TextDecoration.Underline)
                            )
                        )
                    },
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Preview("Light Login", widthDp = 360, heightDp = 640)
@Composable
fun LoginLightPreview(){
    MyTheme {
        LoginScene{
        }
    }
}
@Preview("Dark Login", widthDp = 360, heightDp = 640)
@Composable
fun LoginDarkPreview(){
    MyTheme(darkTheme = true) {
        LoginScene{

        }
    }
}
