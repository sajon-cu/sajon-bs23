package com.inweapp.networkcallbasic.core.utils

import java.net.UnknownHostException

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
data class SmartError(
    override val message: String? = null,
    val code: Int? = null,
    val error: Throwable? = null
) : Throwable(message = message) {

    val hostError: Boolean
        get() = error is UnknownHostException

    val isUnauthorized: Boolean get() =
        code == 401
}