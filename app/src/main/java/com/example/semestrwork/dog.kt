package com.example.semestrwork

data class Dog(
    val id: String,
    val url: String,
    val breeds: List<Breed>
)

data class Breed(
    val name: String
)