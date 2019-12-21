package com.example.truthordare.json

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.truthordare.api.JsonModel
import com.example.truthordare.databinding.JsonelementsBinding


class JsonAdapter(val clickListener: JsonListener) : ListAdapter<JsonModel, JsonAdapter.ViewHolder>(JsonDiffCallBack()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }


    class ViewHolder private constructor(val binding: JsonelementsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: JsonModel, clickListener:JsonListener) {
            binding.jsonModel = item
            binding.clickListener = clickListener
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

class JsonListener(val clickListener: (jsonId: String) -> Unit) {
    fun onClick(jsonModel: JsonModel) = clickListener(jsonModel.id)
}