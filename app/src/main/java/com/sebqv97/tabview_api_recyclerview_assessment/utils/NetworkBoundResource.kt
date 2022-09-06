package com.sebqv97.tabview_api_recyclerview_assessment.utils

import androidx.room.Query
import kotlinx.coroutines.flow.*

fun <ResultType,RequestType>  networkBoundResource(
    query: () -> Flow<ResultType>,
    fetch: suspend () -> RequestType,
    saveFetchResult: suspend (RequestType) -> Unit,
    shouldFetch:(ResultType) -> Boolean =   {true}

) = flow {
    val data  = query().first()

  val flow =  if(shouldFetch(data)){
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map{ Resource.Success(it)}

        }catch (throwable: Throwable){
            query().map { Resource.Error(throwable,it) }
        }

    }else{
        query().map { Resource.Success(it) }
    }
    emitAll(flow)

}