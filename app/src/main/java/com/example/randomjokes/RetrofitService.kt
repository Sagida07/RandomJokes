package com.example.randomjokes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    
    val retrofit = Retrofit.Builder().baseUrl("https://dad-jokes.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(JokesApi::class.java)
}