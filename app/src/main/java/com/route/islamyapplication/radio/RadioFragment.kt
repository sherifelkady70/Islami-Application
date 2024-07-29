package com.route.islamyapplication.radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.route.islamyapplication.R
import com.route.islamyapplication.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    private lateinit var binding : FragmentRadioBinding
    private lateinit var mediaPlayer : MediaPlayer
    private  var isMediaPlayerAvaliable = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        inflater.inflate(R.layout.fragment_radio, container, false)
        binding = FragmentRadioBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAudioPlayer()

        binding.play.setOnClickListener {
            if(isMediaPlayerAvaliable) mediaPlayer.start()
            else Toast.makeText(requireContext() , "Media is still un Available...please wait",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAudioPlayer() {
        val url = "http://........"
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync()
            setOnPreparedListener {
                isMediaPlayerAvaliable = true
            }
        }
    }

}