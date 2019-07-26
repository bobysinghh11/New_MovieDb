package com.stuffshuf.new_moviedb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.MoviesModel
import kotlinx.android.synthetic.main.movie_list.view.*

class Adapter(val context: Context,val modelobject:ArrayList<MoviesModel>) : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {


    var finalUrl = "https://image.tmdb.org/t/p/w342"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.movie_list,parent, false)

        return AdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return modelobject.size

    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val modelss=modelobject[position]
        holder.bind(modelss)
    }

   inner class AdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(moviesModel: MoviesModel){

            with(itemView)
            {
                tvTitle.text=moviesModel.original_title
                Picasso.get().load(finalUrl + moviesModel.poster_path).resize(325, 325).into(images)
            }

        }
    }
}