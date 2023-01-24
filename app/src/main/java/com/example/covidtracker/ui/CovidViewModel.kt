package com.example.covidtracker.ui

import androidx.lifecycle.*
import com.example.covidtracker.api.CovidApiProvider
import com.example.covidtracker.api.CovidData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class CovidViewModel : ViewModel() {

    private val _covidData = MutableLiveData<CovidData>()
    val covidData: LiveData<CovidData> = _covidData

    private val _downloadstatus = MutableStateFlow(Status.WAITING)
    private val _downloadType = MutableStateFlow(CovidDataType.NONE)

    val statusSummary = _downloadstatus.combine(_downloadType){s, dt ->
         "${s.strVal}${dt.strVal}${if (s == Status.DOWNLOADED && _covidData.value != null) ", as of ${SimpleDateFormat("dd/MM/yyyy hh:mm").format(covidData.value!!.lastUpdatedAtSource)}" else ""}"
    }.asLiveData()

    fun updateData(){
        _downloadstatus.value = Status.DOWNLOADING
        _downloadType.value = CovidDataType.WEB
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val data = CovidApiProvider.instance.getLatestData()
                _covidData.postValue(data)
                _downloadstatus.value = Status.DOWNLOADED
            }catch(e: Exception){
                _downloadstatus.value = Status.ERROR
            }
        }
    }
}