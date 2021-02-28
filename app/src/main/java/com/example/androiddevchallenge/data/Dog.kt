package com.example.androiddevchallenge.data

data class Dog(
    val id: String,
    val name: String,
    val age: String?,
    val story: String?,
    val weight: String?,
    val gender: Gender? = Gender.NotDisclosed,
    val breed: String?,
    val imageUrl: String?
)

enum class Gender {
    Male,
    Female,
    NotDisclosed
}