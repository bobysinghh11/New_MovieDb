package com.stuffshuf.new_moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.activity_fourth.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Comment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)


        var finalUrl = "https://image.tmdb.org/t/p/original"

        val retrofit= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org")
            .build()


        val comment = intent.getIntExtra("Comment",1)


        val rev=retrofit.create(MoviesInterface::class.java)
        rev.review(comment).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {



                    reviewsRec.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    Log.d("Reviews", "rev${it.body()!!}")
                    reviewsRec.adapter=ReviewAdapter(it.body()!!.results)


                }

            }
        })


    }
}
