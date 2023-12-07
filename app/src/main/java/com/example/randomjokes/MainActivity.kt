package com.example.randomjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.randomjokes.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.btnJoke.setOnClickListener {
            RetrofitService.api.getJokes().enqueue(object : Callback<JokesModel> {

                override fun onResponse(call: Call<JokesModel>, response: Response<JokesModel>) {
                    binding.tvSetup.text = response.body()?.body?.first()?.setup.toString()
                    binding.tvPunchline.text = response.body()?.body?.first()?.punchline.toString()
                }

                override fun onFailure(call: Call<JokesModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}