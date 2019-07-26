package com.stuffshuf.new_moviedb

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.Movies
import kotlinx.android.synthetic.main.movie_list.view.*


class MoviesAdapter(val result:ArrayList<Movies>):RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

   var finalUrl = "https://image.tmdb.org/t/p/w342"
    companion object
    {
        val MOVIE_ID= "ID"
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.movie_list,parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val resultpos=result[position]
        holder.bind(resultpos)

    }

  inner class MovieViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    {


        fun bind(movies: Movies)
        {
            with(itemView)
            {

                  tvTitle.text=movies.title
                //  tvRelease.text=movies.release_date
                //   tvOverView.text=movies.overview
                //tvPoster.text=movies.poster_path
                //  Picasso.get().load(movies.poster_path).into(images)
             Picasso.get().load(finalUrl + movies.poster_path).resize(325, 325).into(images)

                setOnClickListener {
                    val intent=Intent(context, MovieDetail::class.java)
                    intent.putExtra(MOVIE_ID, movies.id)
                    context.startActivity(intent)
                    Toast.makeText(context, "Clicked id: ${movies.id}", Toast.LENGTH_LONG).show()

                }


            }



        }

    }

}
