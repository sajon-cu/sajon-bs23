package com.inweapp.networkcallbasic.core.extensions

import android.os.Parcelable
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
fun <T : Fragment> AppCompatActivity.replaceFragment(
    container: ViewGroup,
    fragmentClass: Class<T>,
    params: Parcelable? = null,
    tag: String? = null,
    allowStateLoss: Boolean = false,
    useCustomAnimation: Boolean = false) {
    supportFragmentManager.commitTransaction(allowStateLoss) {
        if (useCustomAnimation) {
            // setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
        }
        replace(container.id, fragmentClass, null, tag)
    }
}