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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.dogDetail.DogDetailScreen
import com.example.androiddevchallenge.dogDetail.DogDetailViewModel
import com.example.androiddevchallenge.dogListing.DogListingScreen
import com.example.androiddevchallenge.dogListing.DogListingViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    private val dogsListViewModel by viewModels<DogListingViewModel>()
    private val dogDetailViewModel by viewModels<DogDetailViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(dogsListViewModel, dogDetailViewModel)
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun MyApp(dogsListViewModel: DogListingViewModel, dogDetailViewModel: DogDetailViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "dogsList") {
        composable("dogsList") { DogListingScreen(viewModel = dogsListViewModel, navController = navController) }
        composable(
            "dogDetail/{dogId}",
            arguments = listOf(navArgument("dogId") { type = NavType.StringType })
        ) { backStackEntry ->
            DogDetailScreen(
                viewModel = dogDetailViewModel,
                dogId = backStackEntry.arguments?.getString("dogId")!!
            )
        }
    }
}

// @Preview("Light Theme", widthDp = 360, heightDp = 640)
// @Composable
// fun LightPreview() {
//    MyTheme {
//        MyApp(dogsListViewModel)
//    }
// }
//
// @Preview("Dark Theme", widthDp = 360, heightDp = 640)
// @Composable
// fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp(dogsListViewModel)
//    }
// }
