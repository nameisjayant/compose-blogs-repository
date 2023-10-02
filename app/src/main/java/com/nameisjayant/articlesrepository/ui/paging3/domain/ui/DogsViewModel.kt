package com.nameisjayant.articlesrepository.ui.paging3.domain.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nameisjayant.articlesrepository.ui.paging3.domain.model.DogsModel
import com.nameisjayant.articlesrepository.ui.paging3.domain.repository.DogsPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(
    private val dogsPagingSource: DogsPagingSource
) : ViewModel() {

    private val _dogResponse: MutableStateFlow<PagingData<DogsModel>> =
        MutableStateFlow(PagingData.empty())
    var dogResponse = _dogResponse.asStateFlow()
        private set

    init {
        viewModelScope.launch {
            Pager(
                config = PagingConfig(
                    10, enablePlaceholders = true
                )
            ) {
                dogsPagingSource
            }.flow.cachedIn(viewModelScope).collect {
                _dogResponse.value = it
            }
        }
    }

}