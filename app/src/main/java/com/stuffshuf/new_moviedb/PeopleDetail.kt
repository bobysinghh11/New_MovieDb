package com.stuffshuf.new_moviedb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.PhotoInfo
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.movie_list.*
import kotlinx.android.synthetic.main.peopledetails_list.*
import kotlinx.android.synthetic.main.photo_activity.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PeopleDetail :AppCompatActivity(){


    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()



    var finalUrl = "https://image.tmdb.org/t/p/original/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.peopledetails_list)

        val castId= intent.getIntExtra(CastAdapter.CAST_ID, 1)

       val peopleId = intent.getIntExtra(PeopleAdapter.PEOPLE_ID, 1)


        val peo=retrofit.create(MoviesInterface::class.java)
        peo.people(peopleId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {


                    tvPeople.text=it.body()!!.name
                    Picasso.get().load(finalUrl + it.body()!!.profile_path).resize(850, 650).into(imgPeople)
                    tvOverViewPeople.text=it.body()!!.biography
                    Log.d("Peoels ", "ps${it.body()!!}")


                }

            }
        })

        val cast=retrofit.create(MoviesInterface::class.java)
        cast.people(castId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {


                    tvPeople.text=it.body()!!.name
                    Picasso.get().load(finalUrl + it.body()!!.profile_path).resize(850, 650).into(imgPeople)
                    tvOverViewPeople.text=it.body()!!.biography
                    Log.d("Peoels ", "ps${it.body()!!}")


                }

            }
        })


        tvfullimg.setOnClickListener {

            val intent=Intent(this, FullImages::class.java)
            intent.putExtra("personID", peopleId)
            startActivity(intent)
        }

//        btnphoto.setOnClickListener {

//            val img=retrofit.create(MoviesInterface::class.java)
//            img.image(peopleId).enqueue(retrofitCallback{throwable, response ->
//
//                response?.let {
//
//                    if (it.isSuccessful)
//                    {
//
//
//                        recomPeopleImg.layoutManager=GridLayoutManager(
//                            this,
//                            1,
//                            GridLayoutManager.HORIZONTAL,
//                            false
//                        )
//
//                        recomPeopleImg.adapter=PhotoAdapter(it.body()!!.profiles)
//                        Log.d("HAHHAA", "phsh ${it.body()!!.profiles}")
//
//                    }
//
//                }
//            })
//






    }
}