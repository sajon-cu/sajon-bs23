package com.inweapp.networkcallbasic.core.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@Parcelize
data class Repository(
    val owner: User? = null,
    val description: String? = null
): Parcelable