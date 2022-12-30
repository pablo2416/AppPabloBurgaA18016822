package com.idat.edu.apppabloburgaa18016822.data

import com.idat.edu.apppabloburgaa18016822.data.network.JsonPlaceHolderService
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderFotosModel
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderListadoModel

class JsonPlaceHolderRepository {
    
    private val apiClient = JsonPlaceHolderService()

    suspend fun getMainListData(): List<JsonPlaceholderListadoModel> {
        return apiClient.getMainListData()
    }

    suspend fun getListFotos(): List<JsonPlaceholderFotosModel> {
        return apiClient.getListFotos()
    }
}