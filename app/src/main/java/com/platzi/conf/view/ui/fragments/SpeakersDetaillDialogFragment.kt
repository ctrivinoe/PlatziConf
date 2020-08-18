package com.platzi.conf.view.ui.fragments


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.platzi.conf.R
import com.platzi.conf.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*
import kotlinx.android.synthetic.main.item_speaker.*

class SpeakersDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarSpeaker.setTitleTextColor(Color.WHITE)
        toolbarSpeaker.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker
        toolbarSpeaker.title = speaker.name
        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerJob.text = speaker.jobtitle
        tvDetailSpeakerJobtitle.text  = speaker.workplace
        tvDetailSpeakerBio.text = speaker.biography

        Glide.with(ivDetailImage)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailImage)



        ivTwitterLogo.setOnClickListener{
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/"+url)
            val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
            startActivity(launchBrowser)
        }



    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}
