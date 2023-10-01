package com.nameisjayant.articlesrepository.ui.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MVIRepository @Inject constructor() {

    suspend fun getFruits(): Flow<List<String>> = flow {
        emit(
            fruitsList
        )
    }

}

val fruitsList = listOf(
    "Apple",
    "Mango",
    "Orange",
    "Pine apple",
    "Guava",
    "Black Berry",
)
