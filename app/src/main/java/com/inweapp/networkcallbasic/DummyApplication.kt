package com.inweapp.networkcallbasic

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@HiltAndroidApp
class DummyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Implement Dependency Injection or other staff
    }
}