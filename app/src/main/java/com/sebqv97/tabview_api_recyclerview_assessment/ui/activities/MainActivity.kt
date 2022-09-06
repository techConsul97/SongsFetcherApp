package com.sebqv97.tabview_api_recyclerview_assessment.ui.activities

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.sebqv97.tabview_api_recyclerview_assessment.R
import com.sebqv97.tabview_api_recyclerview_assessment.adapters.OnClickIntent
import com.sebqv97.tabview_api_recyclerview_assessment.adapters.RecordsAdapter
import com.sebqv97.tabview_api_recyclerview_assessment.data.Result
import com.sebqv97.tabview_api_recyclerview_assessment.data.Songs
import com.sebqv97.tabview_api_recyclerview_assessment.data.SongsDatabase
import com.sebqv97.tabview_api_recyclerview_assessment.databinding.TabViewRecyclerViewBinding
import com.sebqv97.tabview_api_recyclerview_assessment.utils.MusicGenreSelection
import com.sebqv97.tabview_api_recyclerview_assessment.utils.networkBoundResource
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    lateinit var binding: TabViewRecyclerViewBinding
    lateinit var songsArray: Songs
    private var currentURL: String = MusicGenreSelection("classick").replaceGenericGenre()
    private var jsonSongsArray = mutableListOf<Result>()


//    //DB
//    //references for dao and database
//     lateinit var db: SongsDatabase
//    val songsDao = db.songsDao()
//
//    fun getSongs() = networkBoundResource(
//        query = {
//            songsDao.getAllSongs()
//        },
//        fetch = {
//            delay(2000)
//            volleyRequest(currentURL)
//        },
//        saveFetchResult = {songs ->
//            db.w
//        }
//    )

    /////////////////////////// =====================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_view_recycler_view)

        //fetch data directly from classic section
        volleyRequest(currentURL)


        binding = TabViewRecyclerViewBinding.inflate(layoutInflater)


        ///BUTTON LISTENERS

        binding.apply {
            buttonClassic.setOnClickListener {
                recyclerView.setBackgroundColor(Color.parseColor("#398DC4"))
                currentURL = MusicGenreSelection("classick").replaceGenericGenre()
                volleyRequest(currentURL)
            }
            buttonPop.setOnClickListener {
                recyclerView.setBackgroundColor(Color.parseColor("#F20970"))
                currentURL = MusicGenreSelection("pop").replaceGenericGenre()
                volleyRequest(currentURL)
            }
            buttonRock.setOnClickListener {
                recyclerView.setBackgroundColor(Color.parseColor("#F20909"))
                currentURL = MusicGenreSelection("rock").replaceGenericGenre()
                volleyRequest(currentURL)
            }
        }


        //Refresh SCREEN
        binding.swipeContainer.setOnRefreshListener {
            jsonSongsArray.clear()

            volleyRequest(currentURL)
            binding.recyclerView.adapter!!.notifyDataSetChanged()
            binding.swipeContainer.isRefreshing = false

            //Toast to prove it is working
            Toast.makeText(this@MainActivity, "REFRESHED", Toast.LENGTH_SHORT).show()


        }


        setContentView(binding.root)
    }

    private fun volleyRequest(url: String) {
        val stringRequest = StringRequest(url,
            {
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                songsArray = gson.fromJson(it, Songs::class.java)
                jsonSongsArray = songsArray.results

                //create adapter including creation of OnCLick EVENT
                val adapter = RecordsAdapter(jsonSongsArray, object : OnClickIntent {
                    override fun OnCLick(pos: Int) {
                        val previewURL = jsonSongsArray[pos].previewUrl
                        openWebPage(previewURL)

                    }
                })

                binding.recyclerView.adapter = adapter
                Toast.makeText(
                    this@MainActivity,
                    "Found ${jsonSongsArray.size} results",
                    Toast.LENGTH_SHORT
                ).show()

            },
            { Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show() }
        )
        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)
    }


    private fun openWebPage(URL: String) {

        val webpage: Uri = Uri.parse(URL)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        startActivity(intent)

    }


//    private fun provideDatabase(): SongsDatabase =
//        Room.databaseBuilder(this, SongsDatabase::class.java, "songs_database").build()
}









