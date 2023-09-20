package com.inweapp.networkcallbasic.features.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inweapp.networkcallbasic.core.data.repositories.GitRepository
import com.inweapp.networkcallbasic.core.utils.SmartError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@HiltViewModel
class RepositoryViewModel @Inject constructor(private val repo: GitRepository): ViewModel() {
    fun getRepositories() {
        viewModelScope.launch {
            try {

            } catch (error: SmartError) {

            }
        }
    }
}