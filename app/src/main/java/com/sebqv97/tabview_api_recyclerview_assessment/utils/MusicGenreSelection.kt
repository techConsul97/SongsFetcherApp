package com.sebqv97.tabview_api_recyclerview_assessment.utils

 class MusicGenreSelection(private val musicType:String) {
    private val baseUrl = "https://itunes.apple.com/search?term=${musicType}&amp;media=music&amp;entity=song&amp;limit=50"

    fun replaceGenericGenre() = baseUrl

}