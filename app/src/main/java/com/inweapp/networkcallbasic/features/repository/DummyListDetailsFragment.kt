package com.inweapp.networkcallbasic.features.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inweapp.networkcallbasic.databinding.FragmentDummyListDetailsBinding
import com.inweapp.networkcallbasic.features.repository.adapter.DummyListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@AndroidEntryPoint
class DummyListDetailsFragment : Fragment() {
    private var _binding: FragmentDummyListDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var dummyAdapter: DummyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDummyListDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as RepositoryActivity).supportActionBar?.title = "Details Fragment"
    }

    companion object {
        private const val TAG = "DummyHomeFragment"
    }
}