package com.inweapp.networkcallbasic.features.repository

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.inweapp.networkcallbasic.R
import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.databinding.FragmentRepositoryDetailsBinding
import com.inweapp.networkcallbasic.features.viewmodel.RepositoryViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


/**
 * Created by sajon on 9/20/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
@AndroidEntryPoint
class RepositoryDetailsFragment : Fragment() {
    private var _binding: FragmentRepositoryDetailsBinding? = null
    private val binding get() = _binding!!

    private val repoViewModel: RepositoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as RepositoryActivity).supportActionBar?.title = "Details Fragment"

        val bundle = this.arguments

        if (bundle != null) {
            val id = bundle.getString(RepositoriesFragment.DUMMY_EXTRA)
            Log.d(TAG, "onViewCreated: $id")

            repoViewModel.getRepoDetails(id)?.let {
                updateViews(it)
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateViews(repository: Repository) {
        binding.tvRepoName.text = repository.fullName
        binding.tvRepoDescription.text = repository.description
        binding.tvRetoType.text = repository.name

        repository.updatedAt?.let { updatedAt ->
            val instant = Instant.parse(updatedAt)
            val localDateTime = instant.atZone(ZoneId.of("UTC")).toLocalDateTime()
            val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")

            val formattedDateTime = localDateTime.format(formatter)
            binding.tvLastUpdate.text = formattedDateTime
        }

        Picasso.get()
            .load(repository.owner?.avatar)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ownerImageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "DummyHomeFragment"
    }
}