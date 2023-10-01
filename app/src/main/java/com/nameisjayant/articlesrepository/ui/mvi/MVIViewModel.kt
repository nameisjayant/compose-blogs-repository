package com.nameisjayant.articlesrepository.ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MVIViewModel @Inject constructor(
    private val repository: MVIRepository
) : ViewModel() {

    // this will store state in form of StateFlow and observed in the COMPOSE UI
    private val _fruitsState: MutableStateFlow<MVIState<String>> =
        MutableStateFlow(MVIState())
    var fruitsState = _fruitsState.asStateFlow()
        private set


    // call this function in your UI to fire events
    fun onEvent(event: MVIEvent) {
        when (event) {
            MVIEvent.ShowFruitsEvent -> viewModelScope.launch {
                _fruitsState.value = MVIState(
                    isLoading = true
                )
                delay(4000L)
                repository.getFruits()
                    .catch {
                        _fruitsState.value = MVIState(
                            error = "",
                        )
                    }.collect {
                        _fruitsState.value = MVIState(
                            data = it,
                        )
                    }
            }
        }
    }

}

// Events
sealed class MVIEvent {
    data object ShowFruitsEvent : MVIEvent()

}

// states
data class MVIState<out T>(
    val data: List<T> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)