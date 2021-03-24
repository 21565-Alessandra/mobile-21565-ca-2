//ALESSANDRA SILVA DOS REIS // ID 21565

package com.reis.kotlinyoutubebta

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder> () {

    val videoTitles = listOf<String>("First title", "Second", "3rd", "MOOOOORE TITLE")

    // Number of Items
    override fun getItemCount(): Int {
        return homeFeed.videos.count()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //How to create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // val videoTitle = videoTitles.get(position)
        val video = homeFeed.videos.get(position)
        holder.view.textView_video_title.text = video.name

        holder.view.textView_channel_name.text = video.channel.name + " • " + "20k Views\n4 days ago"

        val thumbnailImageView = holder.view.imageView_video_thumbnail
        Picasso.with(holder.view.context).load(video.imageUrl).into(thumbnailImageView)

        //holder.view.imageView_channel_profile
        val channelProfileImageView = holder.view.imageView_channel_profile
        Picasso.with(holder.view.context).load(video.channel.profileImageUrl).into(channelProfileImageView)

        holder?.video = video
    }

}

class CustomViewHolder(val view: View, var video: Video? = null) : RecyclerView.ViewHolder (view) {

    companion object{

        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            //println("TEST")

            val intent = Intent(view.context, CourseDetailActivity::class.java)

            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)

            view.context.startActivity(intent)
        }
    }

}






