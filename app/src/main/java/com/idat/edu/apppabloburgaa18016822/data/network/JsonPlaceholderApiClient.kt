package com.idat.edu.apppabloburgaa18016822.data.network

import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderFotosModel
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderListadoModel
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceholderApiClient {
    @GET("todos")
    suspend fun getMainListData(): Response<List<JsonPlaceholderListadoModel>>

    @GET("photos")
    suspend fun getListFotos(): Response<List<JsonPlaceholderFotosModel>>
}