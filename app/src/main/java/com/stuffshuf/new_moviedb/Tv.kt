package com.stuffshuf.new_moviedb

data class TvModel(
    val results:ArrayList<Tv>
)

data class Tv(
    val name:String,
    val poster_path:String
    // val poster: String="https://image.tmdb.org/t/p/w185_and_h278_bestv2/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg"

)


data class TvDetail(

    val id:Int,
    val name:String,
    val overview:String,
    val poster_path:String

)