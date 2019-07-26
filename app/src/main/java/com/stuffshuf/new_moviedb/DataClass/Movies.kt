package com.stuffshuf.new_moviedb.DataClass



data class Model(
    val page:String,
    val results:ArrayList<Movies>
)

data class Movies(
    val id:Int,
    val vote_average:Float,
    val title:String,
    // val release_date:String,
    //val overview:String,
    val poster_path:String
    // val poster: String="https://image.tmdb.org/t/p/w185_and_h278_bestv2/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg"

)

