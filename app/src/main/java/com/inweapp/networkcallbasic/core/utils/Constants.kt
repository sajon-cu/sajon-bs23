package com.inweapp.networkcallbasic.core.utils

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

val header: Map<String, String>
    get() {
        val header = HashMap<String, String>()
        header["ID"] = "com.inweapp.networkcallbasic"
        return header
    }