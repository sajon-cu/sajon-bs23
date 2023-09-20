package com.inweapp.networkcallbasic.features.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.databinding.FragmentDummyBinding
import com.inweapp.networkcallbasic.features.repository.adapter.DummyListAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@AndroidEntryPoint
class RepositoriesFragment : Fragment(), DummyListAdapter.Callback {
    private var _binding: FragmentDummyBinding? = null
    private val binding get() = _binding!!

    private lateinit var dummyAdapter: DummyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDummyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as RepositoryActivity).supportActionBar?.title = "Lists Fragment"
        initRecyclerView()
        loadRepository()
    }

    private fun loadRepository() {
    }

    private fun initRecyclerView() {
        dummyAdapter = DummyListAdapter(this)
        binding.dummyTodoRecyclerView.apply {
            adapter = dummyAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClick(item: Repository) {
        val extra = Bundle().apply {
            putParcelable(DUMMY_EXTRA, item)
        }

        (activity as RepositoryActivity).navigateTo(DummyListDetailsFragment::class.java, extra)
    }

    companion object {
        private const val TAG = "DummyHomeFragment"
        const val DUMMY_EXTRA = "DUMMY_EXTRA"
    }
}