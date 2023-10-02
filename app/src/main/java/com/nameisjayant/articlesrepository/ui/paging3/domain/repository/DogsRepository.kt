package com.nameisjayant.articlesrepository.ui.paging3.domain.repository

import com.nameisjayant.articlesrepository.ui.network.ApiService
import com.nameisjayant.articlesrepository.ui.paging3.domain.model.DogsModel
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getDogs(
        page: Int,
        limit: Int
    ): List<DogsModel> = apiService.getAllDogs(
        page, limit
    )

}