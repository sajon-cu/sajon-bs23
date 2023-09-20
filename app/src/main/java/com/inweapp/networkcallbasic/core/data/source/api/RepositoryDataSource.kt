package com.inweapp.networkcallbasic.core.data.source.api

import com.inweapp.networkcallbasic.core.data.source.remote.repositories.RepositoryResponse

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface RepositoryDataSource {
    @Throws
    suspend fun getAllRepository(queryParam: String): RepositoryResponse?
}