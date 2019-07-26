package com.stuffshuf.new_moviedb.DataClass




data class Casting(

    val cast:ArrayList<Cast>
)

data class Cast(
    val id:Int,
    val name:String,
    val profile_path:String
)