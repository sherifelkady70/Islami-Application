package com.route.islamyapplication.radio

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
            listOfRadio.value = RetrofitObject.getRetrofitInstance().getRadios().radios
        }
    }
}