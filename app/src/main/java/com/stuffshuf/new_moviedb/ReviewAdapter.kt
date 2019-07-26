package com.stuffshuf.new_moviedb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.review.view.*

class ReviewAdapter(val review:ArrayList<Review>):RecyclerView.Adapter<ReviewAdapter.ReviewAdapterViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapterViewHolder {

     val li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView=li.inflate(R.layout.review, parent, false)
        return ReviewAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {

     return review.size
    }

    override fun onBindViewHolder(holder: ReviewAdapterViewHolder, position: Int) {
val reviews=review[position]
        holder.bind(reviews)


    }

    class ReviewAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(review: Review)
        {
            with(itemView)
            {
               reviewAuther.text=review.author
                reviewContent.text=review.content
                reviwID.text=review.id
                reviwURL.text=review.url
            }
        }
    }
}