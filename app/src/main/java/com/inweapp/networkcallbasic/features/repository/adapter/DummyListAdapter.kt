package com.inweapp.networkcallbasic.features.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.inweapp.networkcallbasic.BaseViewHolder
import com.inweapp.networkcallbasic.core.data.models.Repository
import com.inweapp.networkcallbasic.databinding.LayoutDummyListItemBinding

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

        override fun bindData(data: Repository) {
            // binding.tvTodoTitle.text = data.title
        }
    }

    interface Callback {
        fun onItemClick(item: Repository)
    }
}

class TodoListItemCallback: DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.description == newItem.description
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.description == newItem.description && oldItem.description == newItem.description
    }
}