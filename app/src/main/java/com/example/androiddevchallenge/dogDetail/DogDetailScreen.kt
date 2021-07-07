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
package com.example.androiddevchallenge.dogDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun DogDetailScreen(
    dogId: String,
    viewModel: DogDetailViewModel,
    navController: NavHostController
) {
    LaunchedEffect(dogId) {
        viewModel.findDog(id = dogId)
    }
    Surface(color = MaterialTheme.colors.background) {
        val dogState = viewModel.dogData.observeAsState()

        if (dogState.value != null) {
            val dog = dogState.value
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                dog?.imageUrl?.let {
                    Image(
                        painter = rememberCoilPainter(
                            request = it,
                            fadeIn = true
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = CornerSize(0.dp),
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(32.dp),
                                    bottomStart = CornerSize(32.dp)
                                )
                            )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = dog.name,
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(
                            elevation = null,
                            modifier = Modifier
                                .padding(8.dp)
//                                .weight(2f)
                                .height(32.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                text = stringResource(id = R.string.adopt_me_title)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = "🐶 " + dog.breed)
                        Text(text = "🎂 " + dog.age)
                        dog.gender?.let { it1 -> Text(text = it1.name) }
                    }
                    dog.story?.let { it1 ->
                        Text(
                            text = it1,
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
            Icon(
                Icons.Filled.ArrowBack, "back",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        navController.popBackStack()
                    }
                    .padding(12.dp)
            )
        }
    }
}
