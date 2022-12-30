package com.idat.edu.apppabloburgaa18016822.domain

import com.idat.edu.apppabloburgaa18016822.data.JsonPlaceHolderRepository
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderListadoModel

class GetMainListDataInteractor {
    private val repository = JsonPlaceHolderRepository()

    suspend operator fun invoke(): List<JsonPlaceholderListadoModel> {
        val response = repository.getMainListData()
        return if (!response.isNullOrEmpty()) {
            response
        } else emptyList()
    }
}