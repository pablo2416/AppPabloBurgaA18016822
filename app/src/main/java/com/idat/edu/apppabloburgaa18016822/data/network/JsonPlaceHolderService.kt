package com.idat.edu.apppabloburgaa18016822.data.network

import com.idat.edu.apppabloburgaa18016822.core.helpers.RetrofitHelper
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderFotosModel
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderListadoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JsonPlaceHolderService {
    private val apiClient =
        RetrofitHelper.getRetrofit().create(JsonPlaceholderApiClient::class.java)

    suspend fun getMainListData(): List<JsonPlaceholderListadoModel> = withContext(Dispatchers.IO) {
        val response = apiClient.getMainListData()
        response.body() ?: emptyList()
    }

    suspend fun getListFotos(): List<JsonPlaceholderFotosModel> = withContext(Dispatchers.IO) {
        val response = apiClient.getListFotos()
        response.body() ?: emptyList()
    }
}