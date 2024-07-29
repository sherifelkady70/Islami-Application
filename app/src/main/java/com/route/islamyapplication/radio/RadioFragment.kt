package com.route.islamyapplication.radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.route.islamyapplication.R
import com.route.islamyapplication.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    private lateinit var binding : FragmentRadioBinding
    private lateinit var mediaPlayer : MediaPlayer
    private  var isMediaPlayerAvailable = false
    private lateinit var viewModel : RadioViewModel
    private var singleURI = " "

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
        //initAudioPlayer()
        initViewModel()
        binding.play.setOnClickListener {
            if (isMediaPlayerAvailable) {
                mediaPlayer.start()
                binding.play.isVisible = false
            }
            else Toast.makeText(
                requireContext(), "Media is still un Available...please wait",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[RadioViewModel::class.java]
        viewModel.loadRadios()
        viewModel.listOfRadio.observe(viewLifecycleOwner){
            it?.let {
                initAudioPlayer(it[0].url)
            }
        }
        }
    private fun initAudioPlayer(url : String) {
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            Log.d("in radio fragment", url)
            prepareAsync()
            setOnPreparedListener {
                isMediaPlayerAvailable = true
            }
        }
    }
}