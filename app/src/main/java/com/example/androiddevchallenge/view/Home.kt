/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pet

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(navController: NavController) {
    val petList = loadPet()
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
    ) {
        itemsIndexed(items = petList) { index, pet ->
            PetItem(
                pet, index,
                onItemClicked = { _index ->
                    navController.navigate("detail/$_index")
                }
            )
        }
    }
}

@Composable
fun PetItem(pet: Pet, index: Int, onItemClicked: (index: Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clickable(onClick = { onItemClicked(index) })
            .aspectRatio(0.75f)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.75f),
            painter = painterResource(id = pet.image),
            alignment = Alignment.Center,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            val (name, type, genderIcon, age) = createRefs()
            Text(
                text = pet.name,
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(parent.start)
                        bottom.linkTo(type.top)
                    }
                    .padding(bottom = 8.dp),
                style = TextStyle(fontSize = 27.sp, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
            )
            Text(
                text = pet.type,
                modifier = Modifier
                    .constrainAs(type) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .alpha(0.8f)
                    .padding(end = 4.dp),
                style = TextStyle(fontSize = 12.sp, color = Color.White)
            )
            Icon(
                painter = painterResource(id = if (pet.gender) { R.drawable.ic_male } else { R.drawable.ic_female }),
                contentDescription = "gender",
                tint = if (pet.gender) Color.Blue else Color.Red,
                modifier = Modifier
                    .constrainAs(genderIcon) {
                        start.linkTo(type.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(21.dp)
                    .alpha(0.8f)
                    .padding(end = 4.dp)
            )
            Text(
                text = "${pet.age} MTHs",
                modifier = Modifier
                    .constrainAs(age) {
                        start.linkTo(genderIcon.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .alpha(0.8f)
                    .padding(end = 4.dp),
                style = TextStyle(fontSize = 12.sp, color = Color.White)
            )
        }
    }
}

fun loadPet(): List<Pet> {
    val petList = mutableListOf<Pet>()
    petList.add(Pet("GeeGee", "Labrador", true, 20, R.drawable.dog1))
    petList.add(Pet("Kee", "Shepherd", false, 12, R.drawable.dog2))
    petList.add(Pet("Heli", "Golden Retriever", true, 2, R.drawable.dog3))
    petList.add(Pet("Bob", "Bulldog", false, 22, R.drawable.dog4))
    petList.add(Pet("Tata", "Poodle", false, 65, R.drawable.dog5))
    petList.add(Pet("Bobo", "Rottweiler", true, 20, R.drawable.dog6))
    petList.add(Pet("Hoho", "Labrador", false, 7, R.drawable.dog7))
    petList.add(Pet("Coco", "Shepherd", true, 12, R.drawable.dog8))
    petList.add(Pet("GeeGee", "Labrador", true, 20, R.drawable.dog1))
    petList.add(Pet("Kee", "Shepherd", false, 12, R.drawable.dog2))
    petList.add(Pet("Heli", "Golden Retriever", true, 2, R.drawable.dog3))
    petList.add(Pet("Bob", "Bulldog", false, 22, R.drawable.dog4))
    petList.add(Pet("Tata", "Poodle", false, 65, R.drawable.dog5))
    petList.add(Pet("Bobo", "Rottweiler", true, 20, R.drawable.dog6))
    petList.add(Pet("Hoho", "Labrador", false, 7, R.drawable.dog7))
    petList.add(Pet("Coco", "Shepherd", true, 12, R.drawable.dog8))
    return petList
}
