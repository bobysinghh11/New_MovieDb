package com.stuffshuf.new_moviedb.DataClass

data class PeopleModel(
    val page : String,
    val total_pages : String,
    val results:ArrayList<People>
)

data class People(
    //val known_for_department : String,
    val id:Int,
    val name:String,
    val also_known_as : ArrayList<String>,
    val biography : String,
    val popularity : String,
    val profile_path : String

)
