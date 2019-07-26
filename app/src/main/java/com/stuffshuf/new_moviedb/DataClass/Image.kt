package com.stuffshuf.new_moviedb.DataClass

data class Image (
    val profiles:ArrayList<PhotoInfo>

)


data class PhotoInfo(
    val vote_average:Float,
    val file_path:String
)

