package com.inweapp.networkcallbasic.core.data.source.remote.repositories

import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.core.data.source.BaseApiResponse

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
data class RepositoryResponse(
    val items: List<Repository>? = null
): BaseApiResponse()