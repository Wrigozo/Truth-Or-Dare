package com.example.truthordare.json

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.truthordare.api.JsonModel
import com.example.truthordare.databinding.JsonelementsBinding

class JsonAdapter : ListAdapter<JsonModel, JsonAdapter.ViewHolder>(
    JsonDiffCallBack()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val jsonItem = getItem(position)
                holder.bind(jsonItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    class ViewHolder private constructor(val binding: JsonelementsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: JsonModel) {
            binding.jsonModel = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = JsonelementsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class JsonDiffCallBack : DiffUtil.ItemCallback<JsonModel>() {
    override fun areItemsTheSame(oldItem: JsonModel, newItem: JsonModel): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: JsonModel, newItem: JsonModel): Boolean {
        return oldItem == newItem
    }
}