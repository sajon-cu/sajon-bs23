package com.inweapp.networkcallbasic.features.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.core.data.repositories.GitRepository
import com.inweapp.networkcallbasic.core.data.source.remote.repositories.RepositoryResponse
import com.inweapp.networkcallbasic.core.utils.SmartError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
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
    private var _repositories: MutableStateFlow<List<Repository>> = MutableStateFlow(emptyList())
    val repositories: StateFlow<List<Repository>> = _repositories

    // Callback pattern may be omitted and we make it more manageable with kotlin flow api
    fun getRepositories(result: (error: SmartError?) -> Unit) {
        viewModelScope.launch {
            var response: RepositoryResponse? = null
            var mError: SmartError? = null

            try {
                response = repo.getAllRepository("android")
                response?.items?.let {
                    _repositories.value = it
                }
            } catch (error: SmartError) {
                mError = error
            }

            result(mError)
        }
    }

    fun getRepoDetails(id: String?): Repository? {
        val repositories = _repositories.value
        return repositories.find { repo -> repo.id == id}
    }
}