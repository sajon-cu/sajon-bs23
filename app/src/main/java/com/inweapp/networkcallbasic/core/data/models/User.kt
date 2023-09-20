package com.inweapp.networkcallbasic.core.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@Parcelize
class User(
    val login: String? = null,
    @SerializedName("avatar_url")
    val avatar: String? = null
): Parcelable