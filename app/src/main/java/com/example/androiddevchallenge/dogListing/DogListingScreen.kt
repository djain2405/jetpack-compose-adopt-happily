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
package com.example.androiddevchallenge.dogListing

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.google.accompanist.coil.rememberCoilPainter

@ExperimentalFoundationApi
@Composable
fun DogListingScreen(viewModel: DogListingViewModel, navController: NavController) {
    val dogs = viewModel.dogsList.observeAsState(initial = emptyList())
    Surface(color = MaterialTheme.colors.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PageHeader(R.string.adopt_happily)
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                content = {
                    items(dogs.value.size) { index ->
                        val dog = dogs.value[index]
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate("dogDetail/${dog.id}")
                                },
                            border = BorderStroke(2.dp, MaterialTheme.colors.secondaryVariant)

                        ) {
                            Column {
                                dog.imageUrl?.let {
                                    Image(
                                        painter = rememberCoilPainter(
                                            request = it,
                                            fadeIn = true
                                        ),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.height(180.dp)
                                    )
                                }
                                Text(
                                    dog.name,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                    fontWeight = FontWeight.SemiBold
                                )
                                dog.breed?.let {
                                    Text(
                                        it,
                                        style = MaterialTheme.typography.subtitle1,
                                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun PageHeader(titleResId: Int) {
    Text(
        text = stringResource(id = titleResId),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .height(48.dp)
            .padding(12.dp)
    )
}
