package com.stuffshuf.new_moviedb

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.*
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.TrackSelection
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {



    val retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

       navView.setNavigationItemSelectedListener(this)




        val service=retrofit.create(MoviesInterface::class.java)
        service.poplularApi().enqueue(retrofitCallback{throwable, response ->

            response?.let {

                if (it.isSuccessful)
                {


                    recid.layoutManager=GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )

                    recid.adapter=MoviesAdapter(it.body()!!.results)

                }

            }
        })

        val popularmovie=retrofit.create(MoviesInterface::class.java)
        popularmovie.topRated().enqueue(retrofitCallback{ throwable, response ->

            response?.let {
                if (it.isSuccessful)
                {

                    recid1.layoutManager=GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )
                    recid1.adapter=MoviesAdapter(it.body()!!.results)
                }
            }
        })

        val upComing=retrofit.create(MoviesInterface::class.java)
        popularmovie.upComingMovie().enqueue(retrofitCallback{ throwable, response ->

            response?.let {
                if (it.isSuccessful)
                {

                    recid2.layoutManager=GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )
                    recid2.adapter=MoviesAdapter(it.body()!!.results)
                }
            }
        })

        val nowPlaying=retrofit.create(MoviesInterface::class.java)
        popularmovie.nowPlaying().enqueue(retrofitCallback{ throwable, response ->

            response?.let {
                if (it.isSuccessful)
                {

                    recid3.layoutManager=GridLayoutManager(
                        this,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )
                    recid3.adapter=MoviesAdapter(it.body()!!.results)
                }
            }
        })




//        val search=retrofit.create(MoviesInterface::class.java)
//        search.getSearch().enqueue(retrofitCallback{ throwable, response ->
//
//            response?.let {
//                if (it.isSuccessful)
//                {
//
//                    recid3.layoutManager=GridLayoutManager(
//                        this,
//                        1,
//                        GridLayoutManager.HORIZONTAL,
//                        false
//                    )
//                    recid3.adapter=MoviesAdapter(it.body()!!.results)
//                }
//            }
//        })


    }




    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        var manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        var searchItem = menu?.findItem(R.id.search)
        var searchView = searchItem?.actionView as SearchView
        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {


                val newquery=query

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
return false
            }

        })




        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.search -> true

           // R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                 val intent=Intent(this, MainActivity::class.java)
                 startActivity(intent)
            }
            R.id.nav_gallery -> {

                val intent=Intent(this, SecondActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_slideshow -> {

                val intent=Intent(this, Main3Activity::class.java)
                startActivity(intent)
            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

