package com.inweapp.networkcallbasic

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by sajon on 9/19/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var data: T? = null

    internal fun bindListData(data: T) {
        this.data = data
        bindData(data)
    }

    abstract fun bindData(data: T)
}