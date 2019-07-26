package com.stuffshuf.new_moviedb

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stuffshuf.new_moviedb.DataClass.People
import kotlinx.android.synthetic.main.movie_list.view.*

class PeopleAdapter(val people:ArrayList<People>):RecyclerView.Adapter<PeopleAdapter.viewHolder>() {

    var finalUrl = "https://image.tmdb.org/t/p/original/"


    companion object {
        val PEOPLE_ID = "ID"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {


        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.movie_list, parent, false)
        return viewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val peoples = people[position]
        holder.bind(peoples)
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(people: People) {
            with(itemView)
            {
                tvTitle.text = people.name
                Picasso.get().load(finalUrl + people.profile_path).resize(560, 560).into(images)

                setOnClickListener {
                    Toast.makeText(context, "Clicked id: ${people.id}", Toast.LENGTH_LONG).show()

                    val intent = Intent(context, PeopleDetail::class.java)
                    intent.putExtra(PEOPLE_ID, people.id)
                    context.startActivity(intent)
                }

            }
        }
    }
}