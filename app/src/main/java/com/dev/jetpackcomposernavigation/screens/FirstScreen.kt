@file:OptIn(ExperimentalMaterial3Api::class)

package com.dev.jetpackcomposernavigation.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.jetpackcomposernavigation.R
import com.dev.jetpackcomposernavigation.navigation.AppScreens
import com.dev.jetpackcomposernavigation.ui.theme.JetPackComposerNavigationTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar( title = {
            Text("My App")
        })
    }){
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){

    Card{
        var expanded by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Image",
                Modifier.clickable{
                    expanded  = !expanded
                }.animateContentSize())
            AnimatedVisibility(expanded) {
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = { navController.navigate(route = AppScreens.SecondScreen.route + "/Este Es un ejemplo") },
                    modifier = Modifier.animateContentSize()// animar aparecer del Button
                ) {
                    Text("Next Screen")
                }
            }
        }
    }
}

@Preview
@Composable
fun FirstScreenPreview() {
    val navController = rememberNavController()
    JetPackComposerNavigationTheme {
        FirstScreen(navController)
    }
}


