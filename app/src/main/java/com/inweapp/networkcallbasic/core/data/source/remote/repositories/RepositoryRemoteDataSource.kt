package com.inweapp.networkcallbasic.core.data.source.remote.repositories

import com.inweapp.networkcallbasic.core.data.source.api.BaseRemoteDataSource
import com.inweapp.networkcallbasic.core.data.source.api.RepositoryDataSource
import javax.inject.Inject

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class RepositoryRemoteDataSource @Inject constructor(private val service: RepositoryService): RepositoryDataSource, BaseRemoteDataSource() {
    override suspend fun getAllRepository(queryParam: String): RepositoryResponse? {
        return safeApiCall {
            service.getAllRepository(queryParam).execute()
        }
    }
}