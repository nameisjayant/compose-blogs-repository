package com.nameisjayant.articlesrepository.ui.paging3.domain.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nameisjayant.articlesrepository.ui.paging3.domain.model.DogsModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DogsPagingSource @Inject constructor(
    private val repository: DogsRepository
) : PagingSource<Int, DogsModel>() {
    override fun getRefreshKey(state: PagingState<Int, DogsModel>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DogsModel> {
        val page = params.key ?: 1
        val response = repository.getDogs(page, params.loadSize)
        return try {
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(
                e
            )
        } catch (e: HttpException) {
            LoadResult.Error(
                e
            )
        }
    }
}