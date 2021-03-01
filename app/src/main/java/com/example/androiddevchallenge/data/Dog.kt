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
package com.example.androiddevchallenge.data

data class Dog(
    val id: String,
    val name: String,
    val age: String?,
    val story: String?,
    val weight: String?,
    val gender: Gender? = Gender.NotDisclosed,
    val breed: String?,
    val imageUrl: String?,
    val adoptUrl: String?
)

enum class Gender {
    Male,
    Female,
    NotDisclosed
}
