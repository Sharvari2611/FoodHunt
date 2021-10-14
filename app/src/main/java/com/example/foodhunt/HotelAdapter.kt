package com.example.foodhunt

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class HotelAdapter(private var hotName: MutableList<Hotel>,val hotelCallback: (Hotel) -> Unit)
    : RecyclerView.Adapter<HotelAdapter.HotelHolder>() {

 inner class HotelHolder(v: View): RecyclerView.ViewHolder(v){
        val nameTextView = v.findViewById<TextView>(R.id.hotelNameT)
        val descTextView = v.findViewById<TextView>(R.id.hotdescT)
        val hotelImageView: ImageView = v.findViewById<ImageView>(R.id.imageHotelIV)
        val hotelCardView : CardView =v.findViewById(R.id.hotelcardview)
 }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelAdapter.HotelHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.all_hotel_list_item,parent,false)
        return HotelHolder(view)
    }

    override fun onBindViewHolder(holder: HotelAdapter.HotelHolder, position: Int) {
        val hot = hotName[position]
        holder.nameTextView.text = hot.hotelName
        holder.descTextView.text = hot.description
        Glide.with(holder.hotelImageView)
            .load(hot.hotelImageURL)
            .into(holder.hotelImageView)

        holder.hotelCardView.setOnClickListener {
            hotelCallback(hot)
        }

    }



    override fun getItemCount(): Int {
        return hotName.size
    }

}