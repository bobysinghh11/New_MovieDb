package com.stuffshuf.new_moviedb

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.Cast
import com.stuffshuf.new_moviedb.DataClass.Movies
import kotlinx.android.synthetic.main.movie_list.view.*

class CastAdapter(val context: Context, val cast:ArrayList<Cast>) :RecyclerView.Adapter<CastAdapter.CastViewHolder>(){

    var finalUrl = "https://image.tmdb.org/t/p/original"

    companion object{
        val CAST_ID="ID"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {

        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.movie_list,parent, false)
        return CastViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return cast.size

    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val moveisp=cast[position]
        holder.bind(moveisp)

    }

   inner class CastViewHolder(itemvView: View):RecyclerView.ViewHolder(itemvView)
    {
        fun bind(cast: Cast)
        {
            with(itemView)
            {
                tvTitle.text=cast.name
                Picasso.get().load(finalUrl + cast.profile_path).resize(340, 340).into(images)


              setOnClickListener {
                  val intent=Intent(context, PeopleDetail::class.java)
                  intent.putExtra(CAST_ID, cast.id)
                  Log.d("personid", "pers ${cast.id}")
                  context.startActivity(intent)

              }
              }
            }
        }
    }