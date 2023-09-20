package com.inweapp.networkcallbasic.core.data.repositories

import com.inweapp.networkcallbasic.core.data.source.api.RepositoryDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class GitRepository @Inject constructor(private val remote: RepositoryDataSource): RepositoryDataSource {
    override suspend fun getAllRepository(queryParam: String) = withContext(Dispatchers.IO) {
        remote.getAllRepository(queryParam)
    }
}