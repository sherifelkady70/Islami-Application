package com.route.islamyapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islamyapplication.Constants
import com.route.islamyapplication.databinding.FragmentTasbehBinding
import kotlin.properties.Delegates


class tasbehFragment : Fragment() {
    private var displayCounter by Delegates.notNull<Int>()
    private lateinit var binding : FragmentTasbehBinding
    private var currentRotate =0f
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentTasbehBinding.inflate(inflater,container,false)
        return binding.root
    }

//    var displayCounter by Delegates.notNull<Int>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var counter = 1
        binding.numbersBtn.setOnClickListener {
            rotateImage()
             displayCounter = counter++
            binding.numbersBtn.text=displayCounter.toString()
            if(displayCounter==1){
                binding.tsbehBtn.text= Constants.SOBHANAALLA
            }
            if(displayCounter==33){
                binding.tsbehBtn.text= Constants.ELHAMDLLALLA
            }
            if(displayCounter==66){
                binding.tsbehBtn.text= Constants.ALLAHAKBER
            }
            if(displayCounter==100){
                binding.tsbehBtn.text= Constants.SOBHANAALLA
                binding.numbersBtn.text= 1.toString()
                counter=1
            }
        }



        }
    private fun rotateImage(){
        currentRotate+=90f
        binding.bodySebha.rotation=currentRotate
    }

}