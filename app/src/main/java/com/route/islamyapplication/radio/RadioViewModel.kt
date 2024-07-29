package com.route.islamyapplication.radio

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.islamyapplication.radio.api.RetrofitObject
import com.route.islamyapplication.radio.api.models.Radio
import kotlinx.coroutines.launch

class RadioViewModel :ViewModel() {
    var listOfRadio = MutableLiveData<List<Radio>?>()

    fun loadRadios() {
        viewModelScope.launch{
            try{
                val response = RetrofitObject.getRetrofitInstance().getRadios()
                listOfRadio.value = response.radios
                Log.d("in view model", "${RetrofitObject.getRetrofitInstance().getRadios().radios}")
            }catch (e:Exception){
                Log.d("in view model", "exception")
            }
        }
    }
}