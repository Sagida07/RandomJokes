package com.example.randomjokes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface JokesApi {

    @GET("random/joke")

    fun getJokes(
        @Header("X-RapidAPI-Key") key:String = "0ede18e170msh071bc4c8c8972a2p19e4d2jsn4fd74292dada",
        @Header("X-RapidAPI-Host") host: String = "dad-jokes.p.rapidapi.com"
    ): Call<JokesModel>
}