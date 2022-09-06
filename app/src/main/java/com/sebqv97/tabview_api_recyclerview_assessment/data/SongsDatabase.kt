package com.sebqv97.tabview_api_recyclerview_assessment.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Result::class], version = 1)
abstract class SongsDatabase : RoomDatabase(){
    abstract fun songsDao():SongsDao
}