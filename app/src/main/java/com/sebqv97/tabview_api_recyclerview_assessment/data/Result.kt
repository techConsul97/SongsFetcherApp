package com.sebqv97.tabview_api_recyclerview_assessment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val uniqueId:Int = 0,
    val artistId: Int,
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl100: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val collectionArtistId: Int,
    val collectionArtistName: String,
    val collectionArtistViewUrl: String,
    val collectionCensoredName: String,
    val collectionExplicitness: String,
    val collectionHdPrice: Double,
    val collectionId: Int,
    val collectionName: String,
    val collectionPrice: Double,
    val collectionViewUrl: String,
    val contentAdvisoryRating: String,
    val country: String,
    val currency: String,
    val description: String,
    val discCount: Int,
    val discNumber: Int,
    val hasITunesExtras: Boolean,
    val isStreamable: Boolean,
    val kind: String,
    val longDescription: String,
    val previewUrl: String,
    val primaryGenreName: String,
    val releaseDate: String,
    val shortDescription: String,
    val trackCensoredName: String,
    val trackCount: Int,
    val trackExplicitness: String,
    val trackHdPrice: Double,
    val trackHdRentalPrice: Double,
    val trackId: Int,
    val trackName: String,
    val trackNumber: Int,
    val trackPrice: Double,
    val trackRentalPrice: Double,
    val trackTimeMillis: Int,
    val trackViewUrl: String,
    val wrapperType: String
)