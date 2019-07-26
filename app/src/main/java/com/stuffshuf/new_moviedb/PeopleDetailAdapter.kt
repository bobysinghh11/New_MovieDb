package com.stuffshuf.new_moviedb

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.People
import kotlinx.android.synthetic.main.movie_list.view.*

class PeopleDetailAdapter(val people:ArrayList<People>) : RecyclerView.Adapter<PeopleDetailAdapter.PeopleViewHolder>() {

    var finalUrl = "https://image.tmdb.org/t/p/original/"


    companion object{

        val PEOPLE_ID="ID"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {

        val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.movie_list,parent, false)
        return PeopleViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return people.size



    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {

    val poepels= people[position]
        holder.bind(poepels)

    }

   inner class PeopleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    {
        fun bind(people: People)
        {
            with(itemView)
            {
                tvTitle.text=people.name
                Picasso.get().load(finalUrl + people.profile_path).resize(350, 350).into(images)

                setOnClickListener {
                    val intent=Intent(context, PeopleDetail::class.java)
                    intent.putExtra(PEOPLE_ID, people.id)
                    context.startActivity(intent)
                    Log.d("people", "ps ${people.id}")
                }
            }

        }
    }
}

