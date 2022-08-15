package de.skoove.simplemusicplayer.framework.repository

import android.content.ContentValues.TAG
import android.util.Log
import de.skoove.core.domain.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

@ExperimentalCoroutinesApi
inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: (RequestType?) -> Flow<ResultType>,
    crossinline fetch: suspend () -> Response<RequestType>,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: () -> Boolean = { false },
    crossinline onFetchSuccess: () -> Unit = { },
    crossinline onFetchFailed: (Throwable) -> Unit = { }
) = channelFlow {


    if (shouldFetch()) {

        try {
            Log.d(TAG, "networkBoundResource: nothing just checking")
            val fetchedData = fetch()
            if (fetchedData.isSuccessful) {
                onFetchSuccess()
                saveFetchResult(fetchedData.body()!!)
//                loading.cancel()
                query(fetchedData.body()).collect { send(Resource.Success(it)) }
            }else
                query(null).collect { send(Resource.Success(it)) }
        } catch (t: Throwable) {
            Log.d(TAG, "networkBoundResource: ${t.message}")
            query(null).collect { send(Resource.Success(it)) }
            onFetchFailed(t)
//            loading.cancel()

//            query(fetch().body()!!).collect { send(Resource.Failed(t, it)) }
        }
    } else {
        //reading from local Database
        query(null).collect { send(Resource.Success(it)) }
    }
}.catch { e->
    val message: String =e.message.toString()
    Log.e("ServerResponseError", message)
    emit(Resource.Success(query(null).first()))
    onFetchFailed(e)
}