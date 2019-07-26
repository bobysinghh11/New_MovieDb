package com.stuffshuf.new_moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main3Activity : AppCompatActivity() {


    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)




        val service=retrofit.create(MoviesInterface::class.java)
        service.popularpeople().enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {

                    Log.d("Ram", "Dataaa ${it.body()!!.results}")
                    recPeople3.layoutManager= GridLayoutManager(
                        this,
                        2,
                        GridLayoutManager.VERTICAL,
                        false
                    )
                     recPeople3 .adapter=PeopleAdapter(it.body()!!.results)


                }

            }
        })



    }
}
