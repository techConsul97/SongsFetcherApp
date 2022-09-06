package com.sebqv97.tabview_api_recyclerview_assessment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebqv97.tabview_api_recyclerview_assessment.R
import com.sebqv97.tabview_api_recyclerview_assessment.data.Result

import com.sebqv97.tabview_api_recyclerview_assessment.databinding.RecordLayoutBinding
import com.squareup.picasso.Picasso

class RecordsAdapter(private val mList: List<Result>,val onCLick:OnClickIntent) :
    RecyclerView.Adapter<RecordsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.record_layout, parent, false)
        )


    override fun onBindViewHolder(holder: RecordsAdapter.MyViewHolder, position: Int) {
        holder.binding.apply {
            textViewArtist.text = mList[position].artistName
            textViewSongName.text = mList[position].collectionName
            textViewPrice.text = mList[position].trackPrice.toString()
            Picasso.get().load(mList[position].artworkUrl60).into(imageViewRecord)
        }

        //for each element a click listener will be set with callback pointing to onClick variable
        holder.itemView.setOnClickListener{onCLick.OnCLick(position)}
    }


    override fun getItemCount() = mList.size


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RecordLayoutBinding.bind(itemView)
    }


}