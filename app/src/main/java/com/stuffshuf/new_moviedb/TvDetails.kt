package com.stuffshuf.new_moviedb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.peopledetails_list.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TvDetails :AppCompatActivity() {

    var finalUrl = "https://image.tmdb.org/t/p/original"

    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tvdetails)


//        val tv=retrofit.create(MoviesInterface::class.java)
//       tv.tvDetails(peopleId).enqueue(retrofitCallback{throwable, response ->
//
//            response?.let {
//
//                if (it.isSuccessful)
//                {
//
//
//                    tvPeople.text=it.body()!!.name
//                    Picasso.get().load(finalUrl + it.body()!!.profile_path).resize(850, 650).into(imgPeople)
//                    tvOverViewPeople.text=it.body()!!.biography
//                    Log.d("Peoels ", "ps${it.body()!!}")
//
//
//                }
//
//            }
//        })



    }
}