package com.example.randomjokes

data class JokesModel(
    val body: List<JokesModell>
)

data class JokesModell(
    val setup: String,
    val punchline: String
)