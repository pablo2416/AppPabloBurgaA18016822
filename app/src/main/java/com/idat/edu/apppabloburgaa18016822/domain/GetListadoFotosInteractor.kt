package com.idat.edu.apppabloburgaa18016822.domain

import com.idat.edu.apppabloburgaa18016822.data.JsonPlaceHolderRepository
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderFotosModel

class GetListadoFotosInteractor {

    private val repository = JsonPlaceHolderRepository()
    suspend operator fun invoke(): List<JsonPlaceholderFotosModel> {
        val response = repository.getListFotos()
        return if (!response.isNullOrEmpty())
            response
        else emptyList()
    }
}