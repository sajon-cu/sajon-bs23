package com.inweapp.networkcallbasic.features.repository.adapter

import android.os.Build
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.inweapp.networkcallbasic.BaseViewHolder
import com.inweapp.networkcallbasic.R
import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.databinding.LayoutDummyListItemBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by sajon on 9/19/23
 * Copyright (c) 2023 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class DummyListAdapter(private val listener: Callback) : ListAdapter<Repository, BaseViewHolder<Repository>>(
    TodoListItemCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Repository> {
        return LayoutDummyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
            TodosViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Repository>, position: Int) {
        holder.bindListData(getItem(position))
    }

    inner class TodosViewHolder(private val binding: LayoutDummyListItemBinding) : BaseViewHolder<Repository>(binding.root) {
        init {
            binding.root.setOnClickListener { listener.onItemClick(data!!) }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun bindData(data: Repository) {
            binding.tvRepoName.text = data.fullName
            binding.tvRepoDescription.text = data.description
            binding.tvRetoType.text = data.name

            data.updatedAt?.let { updatedAt ->
                val instant = Instant.parse(updatedAt)
                val localDateTime = instant.atZone(ZoneId.of("UTC")).toLocalDateTime()
                val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")

                val formattedDateTime = localDateTime.format(formatter)
                binding.tvLastUpdate.text = formattedDateTime
            }

            Picasso.get()
                .load(data.owner?.avatar)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ownerImageView)
        }
    }

    interface Callback {
        fun onItemClick(item: Repository)
    }

    companion object {
        val inputFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    }
}

class TodoListItemCallback: DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id && oldItem.description == newItem.description
    }
}