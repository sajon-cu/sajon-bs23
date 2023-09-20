package com.inweapp.networkcallbasic.features.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.databinding.FragmentDummyBinding
import com.inweapp.networkcallbasic.features.repository.adapter.DummyListAdapter
import com.inweapp.networkcallbasic.features.viewmodel.RepositoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

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

    private val repoViewModel: RepositoryViewModel by activityViewModels()
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
        repoViewModel.repositories.map { it }.distinctUntilChanged().asLiveData().observe(viewLifecycleOwner) { items ->
            dummyAdapter.submitList(items)
        }
    }

    private fun loadRepository() {
        repoViewModel.getRepositories { error ->
            error?.let {
                Toast.makeText(requireContext(), "Something wired happened", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initRecyclerView() {
        dummyAdapter = DummyListAdapter(this)
        binding.dummyTodoRecyclerView.apply {
            adapter = dummyAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onItemClick(item: Repository) {
        item.id?.let {
            val extra = Bundle().apply {
                putString(DUMMY_EXTRA, it)
            }
            (activity as RepositoryActivity).navigateTo(RepositoryDetailsFragment::class.java, extra)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "DummyHomeFragment"
        const val DUMMY_EXTRA = "DUMMY_EXTRA"
    }
}