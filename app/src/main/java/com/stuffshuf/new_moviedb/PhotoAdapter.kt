package com.stuffshuf.new_moviedb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.Image
import com.stuffshuf.new_moviedb.DataClass.PhotoInfo
import kotlinx.android.synthetic.main.photo_activity.view.*

class PhotoAdapter(val photos:ArrayList<PhotoInfo>) :RecyclerView.Adapter<PhotoAdapter.PhotoAdapterViewHolder>(){

    var finalUrl = "https://image.tmdb.org/t/p/original/"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapterViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.photo_activity, parent, false)
        return PhotoAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return photos.size
    }

    override fun onBindViewHolder(holder: PhotoAdapterViewHolder, position: Int) {
     val photoss= photos[position]
        holder.bind(photoss)

    }

   inner class PhotoAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(photoInfo: PhotoInfo)
        {
            with(itemView)
            {
                Picasso.get().load(finalUrl + photoInfo.file_path).into(imgImage)
            }
        }
    }
}