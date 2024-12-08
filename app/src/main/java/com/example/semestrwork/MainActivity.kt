package com.example.semestrwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dogAdapter: DogAdapter
    private val dogList = mutableListOf<Dog>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewDogs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        dogAdapter = DogAdapter(dogList)
        recyclerView.adapter = dogAdapter

        fetchDogImages()
    }

    private fun fetchDogImages() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.apiService.getDogImages(
                    limit = 20,
                    page = 0,
                    order = "Desc"
                )
                Log.d("123", response.toString())
                withContext(Dispatchers.Main) {
                    dogAdapter.updateData(response)
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Ошибка при получении данных", e)
            }
        }
    }
}