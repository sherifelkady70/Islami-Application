package com.route.islamyapplication.radio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islamyapplication.R
import com.route.islamyapplication.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    lateinit var binding : FragmentRadioBinding
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

}