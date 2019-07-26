package com.stuffshuf.new_moviedb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.VideosDetail
import kotlinx.android.synthetic.main.activity_fourth.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.movie_list.*
import kotlinx.android.synthetic.main.movie_list.view.*
import kotlinx.android.synthetic.main.peopledetails_list.*
import kotlinx.android.synthetic.main.review.*
import kotlinx.android.synthetic.main.videotrailer.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDetail :AppCompatActivity()
{

    var finalUrl = "https://image.tmdb.org/t/p/original"

    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()

//    var exoData = intent.getStringExtra(VideoAdapter.exoKEY)

    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var playbackPosition = 0L

    private val bandwidthMeter by lazy {
        DefaultBandwidthMeter()
    }
    private val adaptiveTrackSelectionFactory by lazy {
        AdaptiveTrackSelection.Factory(bandwidthMeter)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val actionbar=supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayShowHomeEnabled(false)




        val userId = intent.getIntExtra(MoviesAdapter.MOVIE_ID, 1)


        Log.d("movi", "ms$userId")


        val service=retrofit.create(MoviesInterface::class.java)
        service.popularmovie(userId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {

//                    Log.d("HH", "Data ${it.body()!!}")
//                    tvRec.layoutManager= GridLayoutManager(
//                        this,
//                        1,
//                        GridLayoutManager.HORIZONTAL,
//                        false
//                    )

                  tv2.text=it.body()!!.original_title

                    Picasso.get().load(finalUrl +it.body()!!.poster_path).resize(1300, 800).into(img)
                    tvOverView.text=it.body()!!.overview

               //  tvRec.adapter=Adapter(this, it.body()!!)


                }

            }
        })
        val rec=retrofit.create(MoviesInterface::class.java)
        rec.recommendations(userId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {


                    Log.d("HH", "Data ${it.body()!!}")
                    recomRec.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    recomRec.adapter=MoviesAdapter(it.body()!!.results)
                }

            }
        })


//        val rev=retrofit.create(MoviesInterface::class.java)
//        rev.review(userId).enqueue(retrofitCallback{throwable, response ->
//
//            response?.let {
//
//                if (it.isSuccessful)
//                {
//
//
//
//                    reviewRec.layoutManager= GridLayoutManager(
//                        this,
//                        1,
//                        GridLayoutManager.HORIZONTAL,
//                        false
//                    )
//
//                   Log.d("Reviews", "rev${it.body()!!}")
//                    reviewRec.adapter=ReviewAdapter(it.body()!!.results)
//
//
//                }
//
//            }
//        })

        val sim=retrofit.create(MoviesInterface::class.java)
        sim.similarMovie(userId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {



                    recsimmilar.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    Log.d("Reviews", "rev${it.body()!!}")
                    recsimmilar.adapter=MoviesAdapter(it.body()!!.results)


                }

            }
        })


        val video=retrofit.create(MoviesInterface::class.java)
        video.videoTrailer(userId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {



                    videosRec.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    Log.d("Vidoes", "rev${it.body()!!}")
                    videosRec.adapter=VideoAdapter(this, it.body()!!.results)


                }

            }
        })

        val cast=retrofit.create(MoviesInterface::class.java)
        cast.cast(userId).enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {



                    castingRec.layoutManager= GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    Log.d("Vidoes", "rev${it.body()!!}")
                   castingRec.adapter=CastAdapter(this,it.body()!!.cast)


                }

            }
        })


//        val persn=retrofit.create(MoviesInterface::class.java)
//        persn.people(prsnId).enqueue(retrofitCallback{throwable, response ->
//
//            response?.let {
//
//                if (it.isSuccessful)
//                {
//
//
//
////                    castingRec.layoutManager= GridLayoutManager(
////                        this,
////                        1,
////                        GridLayoutManager.HORIZONTAL,
////                        false
////                    )
//
//                    tvPeople.text=it.body()!!.name
//                    Picasso.get().load(finalUrl + it.body()!!.profile_path).resize(850, 650).into(imgPeople)
//                    tvOverViewPeople.text=it.body()!!.biography
//                    Log.d("Peoels ", "ps${it.body()!!}")
//
//                }
//
//            }
//        })

        reviews.setOnClickListener {

            val intent=Intent(this, Comment::class.java)
            intent.putExtra("Comment", userId)
            startActivity(intent)
        }



    }


//    private fun initializeExoplayer() {
//        simpleExoplayer = ExoPlayerFactory.newSimpleInstance(
//            DefaultRenderersFactory(this),
//            DefaultTrackSelector(adaptiveTrackSelectionFactory),
//            DefaultLoadControl()
//        )
//
//        prepareExoplayer()
//        simpleExoPlayerView.player = simpleExoplayer
//        simpleExoplayer.seekTo(playbackPosition)
//        simpleExoplayer.playWhenReady = true
////        simpleExoplayer.addListener()
//    }
//
//    private fun releaseExoplayer() {
//        playbackPosition = simpleExoplayer.currentPosition
//        simpleExoplayer.release()
//    }
//
//    private fun buildMediaSource(uri: Uri): MediaSource {
//        val dataSourceFactory = DefaultHttpDataSourceFactory("ua", bandwidthMeter)
//        val dashChunkSourceFactory = DefaultDashChunkSource.Factory(dataSourceFactory)
//        return DashMediaSource(uri, dataSourceFactory, dashChunkSourceFactory, null, null)
//    }
//
//    private fun prepareExoplayer() {
//        val uri = Uri.parse(exoData)
//        val mediaSource = buildMediaSource(uri)
//        simpleExoplayer.prepare(mediaSource)
//    }
//


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
