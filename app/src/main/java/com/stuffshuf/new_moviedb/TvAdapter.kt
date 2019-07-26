package com.stuffshuf.new_moviedb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list.view.*


class TvAdapter(val result:ArrayList<Tv>) :RecyclerView.Adapter<TvAdapter.viewHolder>(){

    var finalUrl = "https://image.tmdb.org/t/p/w342"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.movie_list,parent, false)
        return viewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val results= result[position]
        holder.bind(results)

    }


   inner class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {


        fun bind(tv: Tv)
        {
            with(itemView)
            {

                tvTitle.text=tv.name
                //  tvRelease.text=movies.release_date
                //   tvOverView.text=movies.overview
                //tvPoster.text=movies.poster_path
                //  Picasso.get().load(movies.poster_path).into(images)
                Picasso.get().load(finalUrl + tv.poster_path).resize(325, 325).into(images)


            }



        }

    }

}

