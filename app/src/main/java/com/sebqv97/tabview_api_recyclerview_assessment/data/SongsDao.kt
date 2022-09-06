package com.sebqv97.tabview_api_recyclerview_assessment.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface SongsDao {

    @Query("SELECT * FROM songs")
    fun getAllSongs():Flow<Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<Result>)

    @Query("DELETE FROM songs")
    suspend fun deleteAllSongs()
}