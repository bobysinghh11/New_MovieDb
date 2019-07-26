package com.stuffshuf.new_moviedb

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.Videos
import com.stuffshuf.new_moviedb.DataClass.VideosDetail
import kotlinx.android.synthetic.main.activity_fourth.view.*
import kotlinx.android.synthetic.main.movie_list.view.*
import kotlinx.android.synthetic.main.videotrailer.view.*

class VideoAdapter(val context: Context, val video:ArrayList<VideosDetail>) :RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){




    var finalUrl="https://www.youtube.com/watch?v="

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
     val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.videotrailer, parent, false)
        return VideoViewHolder(itemView)

    }

    override fun getItemCount(): Int {

     return video.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        val videoss= video[position]
        holder.bind(videoss)



    }

  class VideoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


    {


        var finalUrl="https://www.youtube.com/watch?v="


        fun bind(videosDetail: VideosDetail)
        {


            with(itemView)
            {




              videoTitle.text=videosDetail.name




                setOnClickListener {

                    videoTrailer.setVideoPath(finalUrl + videosDetail.key)



                    val i=Intent()
                    i.data= Uri.parse(finalUrl + videosDetail.key)
                    context.startActivity(i)
                    Log.d("Videos", "V ${videosDetail.key}")
                    Log.d("Videoss", "V ${finalUrl + videosDetail.key}")

                }


                }
            }

        }



    }