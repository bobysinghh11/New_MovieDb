package com.stuffshuf.new_moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_full_images.*
import kotlinx.android.synthetic.main.peopledetails_list.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FullImages : AppCompatActivity() {

    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()


    var finalUrl = "https://image.tmdb.org/t/p/original/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_images)


      val peopleId = intent.getIntExtra("personID" ,1)

        val img=retrofit.create(MoviesInterface::class.java)
        img.image(peopleId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {


                    fullimg.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )



                  fullimg.adapter=PhotoAdapter(it.body()!!.profiles)
                    Log.d("HAHHAA", "phsh ${it.body()!!.profiles}")

                }

            }
        })




    }
}
