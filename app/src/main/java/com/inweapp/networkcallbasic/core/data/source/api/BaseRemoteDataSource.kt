package com.inweapp.networkcallbasic.core.data.source.api

import android.util.Log
import com.inweapp.networkcallbasic.core.data.source.BaseApiResponse
import com.inweapp.networkcallbasic.core.utils.SmartError
import retrofit2.Response
import java.net.UnknownHostException

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
abstract class BaseRemoteDataSource {
    private val TAG = "BaseRemoteDataSource"

    suspend fun <T: BaseApiResponse> safeApiCall(apiToBeCalled: suspend () -> Response<T>): T? {
        try{
            val response: Response<T> = apiToBeCalled()

            return if(response.isSuccessful) {
                val result = response.body()
                Log.d(TAG, "safeApiCall: $result")
                result
            } else {
                throw SmartError(message = "Something went wrong!")
            }
        } catch (error: Throwable) {
            Log.d(TAG, "safeApiCall: $error")
            if(error is SmartError) throw error
            if(error is UnknownHostException) throw SmartError(
                message = error.message,
                error = error
            )

            throw SmartError(
                message = error.message,
                error = error
            )
        }
    }
}