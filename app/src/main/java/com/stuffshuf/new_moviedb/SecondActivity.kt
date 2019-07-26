package com.stuffshuf.new_moviedb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity(){

    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       //var movieid= intent.getIntExtra(MoviesAdapter.MovieViewHolder.MOVIES_ID, 1)

      supportActionBar?.title="Tv Shows"



        val service=retrofit.create(MoviesInterface::class.java)
        service.tvPopular().enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {

                    Log.d("second", "Data ${it.body()!!.results}")
                    tvRec.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    tvRec.adapter=TvAdapter(it.body()!!.results)

                }

            }
        })

        val tvTopRated=retrofit.create(MoviesInterface::class.java)
        service.tvTopRated().enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {

                    Log.d("second", "Data ${it.body()!!.results}")
                    tvRec1.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    tvRec1.adapter=TvAdapter(it.body()!!.results)

                }

            }
        })

        val tvOnAir=retrofit.create(MoviesInterface::class.java)
        service.tvOnAIR().enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {

                    Log.d("second", "Data ${it.body()!!.results}")
                    tvRec3.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    tvRec3.adapter=TvAdapter(it.body()!!.results)

                }

            }
        })

        val tvAirToday=retrofit.create(MoviesInterface::class.java)
        service.tvAIRToday().enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {

                    Log.d("second", "Data ${it.body()!!.results}")
                    tvRec4.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    tvRec4.adapter=TvAdapter(it.body()!!.results)

                }

            }
        })
    }
}

