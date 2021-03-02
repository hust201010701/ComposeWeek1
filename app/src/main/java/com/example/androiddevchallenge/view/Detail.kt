package com.example.androiddevchallenge.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Detail(navController: NavController, index: Int) {
    val petList = loadPet()
    val pet = petList[index]
    Surface(color = Color.Black) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = pet.image),
                alignment = Alignment.Center,
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            Text(text = "About Me", modifier = Modifier
                .padding(start = 8.dp, top = 8.dp),
                style = TextStyle(fontSize = 40.sp, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif))

            Text(text = "Name: ${pet.name}", modifier = Modifier
                .padding(start = 8.dp, top = 8.dp),
                style = TextStyle(fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif))

            Text(text = "Type: ${pet.type}", modifier = Modifier
                .padding(start = 8.dp, top = 8.dp),
                style = TextStyle(fontSize = 16.sp, color = Color.White, fontFamily = FontFamily.SansSerif))

            Text(text = "Gender: ${if(pet.gender) "Male" else "Female"}", modifier = Modifier
                .padding(start = 8.dp, top = 8.dp),
                style = TextStyle(fontSize = 16.sp, color = Color.White, fontFamily = FontFamily.SansSerif))

            Text(text = "Age: ${pet.age} MONTHS", modifier = Modifier
                .padding(start = 8.dp, top = 8.dp),
                style = TextStyle(fontSize = 16.sp, color = Color.White, fontFamily = FontFamily.SansSerif))

            Text(text = "My Story", modifier = Modifier
                .padding(start = 8.dp, top = 20.dp),
                style = TextStyle(fontSize = 40.sp, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif))

            Text(text = "Desc: ${pet.desc}", modifier = Modifier
                .padding(start = 8.dp, top = 8.dp),
                style = TextStyle(fontSize = 12.sp, color = Color.White, fontFamily = FontFamily.SansSerif))

            Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 32.dp), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {

                }, Modifier.background(Color.Green, RoundedCornerShape(8.dp)).width(200.dp).height(54.dp)) {
                    Text(text = "Adopt Me", color = Color.White, style = TextStyle(fontSize = 27.sp))
                }
            }

        }


    }
}