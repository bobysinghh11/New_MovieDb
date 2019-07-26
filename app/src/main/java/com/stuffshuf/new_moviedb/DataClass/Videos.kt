package com.stuffshuf.new_moviedb.DataClass

data class Videos (

    val id:Int,
    val results:ArrayList<VideosDetail>

)

data class VideosDetail(

    val id:String,
    val iso_639_1:String,
    val iso_3166_1:String,
    val key:String,
    val name:String
)