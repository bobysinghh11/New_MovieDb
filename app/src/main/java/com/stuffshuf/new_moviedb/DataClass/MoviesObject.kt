package com.stuffshuf.new_moviedb.DataClass



data class MoviesModel(
    val adult:Boolean,
    val genres:ArrayList<Genres>,
    val id:Int,
    val original_title:String,
    val overview:String,
    // val release_date:String,
    //val overview:String,
    val poster_path:String
    // val poster: String="https://image.tmdb.org/t/p/w185_and_h278_bestv2/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg"

)

data class Genres(
    val name:String
)