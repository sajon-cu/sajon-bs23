package com.inweapp.networkcallbasic.core.data.source.remote.repositories

import com.inweapp.networkcallbasic.core.utils.header
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface RepositoryService {
    @GET("search/repositories")
    fun getAllRepository(
        @Query("q") param: String,
        @Query("sort") sortWith: String? = "stars",
        @HeaderMap headers: Map<String, String>? = header
    ): Call<RepositoryResponse>
}