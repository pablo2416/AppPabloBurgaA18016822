package com.idat.edu.apppabloburgaa18016822.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderFotosModel
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderListadoModel
import com.idat.edu.apppabloburgaa18016822.domain.GetListadoFotosInteractor
import com.idat.edu.apppabloburgaa18016822.domain.GetMainListDataInteractor
import kotlinx.coroutines.launch

class JsonPlaceHolderViewModel : ViewModel() {
    private val getMainListDataInteractor = GetMainListDataInteractor()
    private val getListadoFotosInteractor = GetListadoFotosInteractor()
    val responseListMainData = MutableLiveData<List<JsonPlaceholderListadoModel>>()
    val responseListFotos = MutableLiveData<List<JsonPlaceholderFotosModel>>()

    fun obtenerListadoPrincipal() {
        viewModelScope.launch {
            val result = getMainListDataInteractor()
            if (!result.isNullOrEmpty()) responseListMainData.postValue(result)
        }
    }

    fun obtenerListadoFotos() {
        viewModelScope.launch {
            val result = getListadoFotosInteractor()
            if (!result.isNullOrEmpty()) responseListFotos.postValue(result)
        }
    }
}