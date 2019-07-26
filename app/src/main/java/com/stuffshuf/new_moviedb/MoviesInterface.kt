package com.stuffshuf.new_moviedb


import com.stuffshuf.new_moviedb.DataClass.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesInterface {

    @GET("3/movie/popular?api_key=b66192ee7c7db9131b165b78d382ea60")

    fun poplularApi():Call<Model>


    @GET("https://api.themoviedb.org/3/movie/{id}?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US")
    fun popularmovie(
        @Path("id") id : Int) : Call<MoviesModel>


    @GET("3/movie/{id}/recommendations?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun recommendations(@Path("id")id:Int):Call<Model>

    @GET("3/movie/{id}/similar?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun similarMovie(@Path("id")id:Int):Call<Model>


    @GET("3/movie/top_rated?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun topRated():Call<Model>

    @GET("3/movie/{id}/videos?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US")
    fun videoTrailer(@Path("id")id:Int):Call<Videos>

    @GET("https://api.themoviedb.org/3/movie/{id}/credits?api_key=b66192ee7c7db9131b165b78d382ea60")
    fun cast(@Path("id")id:Int):Call<Casting>

    @GET("https://api.themoviedb.org/3/search/multi?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&query=spider&page=3&include_adult=false")
    fun getSearch(@Query("query")query:String):Call<Model>



    @GET("3/movie/upcoming?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun upComingMovie(): Call<Model>

    @GET("3/movie/now_playing?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun nowPlaying():Call<Model>

    @GET("/3/movie/2?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US")
    fun movies():Call<Model>


    @GET("3/tv/popular?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun tvPopular():Call<TvModel>

    @GET("3/tv/top_rated?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun tvTopRated():Call<TvModel>

    @GET("3/tv/on_the_air?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun tvOnAIR():Call<TvModel>

    @GET("3/tv/airing_today?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun tvAIRToday():Call<TvModel>

    @GET("https://api.themoviedb.org/3/tv/{id}?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US")
    fun tvDetails(@Path("id")id:Int):Call<TvDetail>

//    @GET("3/person/popular?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
//    fun popularpeople():Call<PeopleModel>

    @GET("3/person/popular?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun popularpeople():Call<PeopleModel>

    @GET("https://api.themoviedb.org/3/person/{id}?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US")
    fun people(@Path("id") id:Int):Call<People>


//    @GET("3/person/122158/{id}?api_key=b66192ee7c7db9131b165b78d382ea60")
//    fun image(@Path("id") id:Int):Call<Image>

    @GET("3/movie/{id}/reviews?api_key=b66192ee7c7db9131b165b78d382ea60&language=en-US&page=1")
    fun review(@Path("id")id:Int):Call<ReviewModel>


    // Images

    @GET("https://api.themoviedb.org/3/person/{id}/images?api_key=b66192ee7c7db9131b165b78d382ea60")
    fun image(@Path("id") id:Int):Call<Image>


}