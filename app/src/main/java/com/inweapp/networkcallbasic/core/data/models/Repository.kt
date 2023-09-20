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
data class Repository(
    val id: String? = null,
    val name: String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    val owner: User? = null,
    val description: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
): Parcelable