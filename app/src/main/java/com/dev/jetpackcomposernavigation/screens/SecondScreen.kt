@file:OptIn(ExperimentalMaterial3Api::class)

package com.dev.jetpackcomposernavigation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavController, text : String?){
    Scaffold(topBar = {
        TopAppBar(title = {
           Row(verticalAlignment =  Alignment.CenterVertically) {
               Icon(imageVector = Icons.Default.ArrowBack,
                   contentDescription = "back arrow",
                   modifier = Modifier.clickable {
                       navController.popBackStack()
                   })
               Spacer(modifier = Modifier.width(25.dp))
               Text("Second Screen 2")
           }
        })

    }){
        BodySecond(navController, text)
    }
}

@Composable
fun BodySecond(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola Navegación pantalla 2")
        text?.let{
            Text(it)
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Back Screen")
        }
    }
}

