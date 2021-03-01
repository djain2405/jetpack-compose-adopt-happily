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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetailScreen(dogId: String, viewModel: DogDetailViewModel) {
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
                    CoilImage(
                        data = it,
                        contentDescription = null,
                        fadeIn = true,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
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
                }
            }
        }
    }
}
