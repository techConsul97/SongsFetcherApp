package com.sebqv97.tabview_api_recyclerview_assessment.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso


object PicassoService {

    //doesn't work..
    fun insertImageFromUrl( URL: String, imageView:ImageView){
        Picasso.get().load(URL).into(imageView)
    }
}