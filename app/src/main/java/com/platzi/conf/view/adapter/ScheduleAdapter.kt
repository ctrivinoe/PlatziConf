package com.platzi.conf.view.adapter

import com.platzi.conf.model.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R
import java.util.*
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

class ScheduleAdapter (val scheduleListener: ScheduleAdapter) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))


    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

            holder.tvConferenceName.text = conference.title
            holder.tvConferenceSpeaker.text = conference.speaker
            holder.tvConferenceTag.text = conference.tag

            val cal = Calendar.getInstance()
            cal.time = conference.datetime
            val hourFormat = SimpleDateFormat().format(conference.datetime)

            holder.tvConferenceHour.text = hourFormat
            holder.tvConferenceAMPM.text = SimpleDateFormat().format(conference.datetime).toUpperCase()

    }

    fun updateData(data: List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleHourAMPM)
    }
}