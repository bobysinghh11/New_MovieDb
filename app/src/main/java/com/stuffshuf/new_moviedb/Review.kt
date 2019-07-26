package com.stuffshuf.new_moviedb


data class ReviewModel(
    val id:Int,
    val page:Int,
    val results:ArrayList<Review>
)


data class Review (

    val author:String,
    val content:String,
    val id:String,
    val url:String
)