package com.example.samplecleanarchitecture.ui.department.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.samplecleanarchitecture.base.BaseListAdapter
import com.example.samplecleanarchitecture.base.BaseViewHolder
import com.example.samplecleanarchitecture.databinding.ItemDepartmentBinding
import com.example.samplecleanarchitecture.ui.department.model.Department
import com.example.samplecleanarchitecture.utils.loadImage
import com.example.samplecleanarchitecture.utils.setCornerRadius
import com.example.samplecleanarchitecture.utils.toDp

class DepartmentAdapter :
    BaseListAdapter<Department, ItemDepartmentBinding, DepartmentAdapter.DepartmentViewHolder>(
        diffCallback
    ) {

    private var onItemClick: (Department) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DepartmentViewHolder(ItemDepartmentBinding.inflate(layoutInflater, parent, false))
    }

    fun setOnItemClickListener(onItemClick: (Department) -> Unit) {
        this.onItemClick = onItemClick
    }

    inner class DepartmentViewHolder(binding: ItemDepartmentBinding) :
        BaseViewHolder<Department, ItemDepartmentBinding>(binding) {

        init {
            binding.root.setOnClickListener {
                data?.let { onItemClick(it) }
            }
        }

        override fun onBindData(data: Department) {
            super.onBindData(data)
            binding.name.text = data.name
            binding.image.loadImage(data.image)
            binding.image.setCornerRadius(topLeft = 8f.toDp(), topRight = 8f.toDp())
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Department>() {
            override fun areItemsTheSame(oldItem: Department, newItem: Department): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Department, newItem: Department): Boolean {
                return oldItem == newItem
            }
        }
    }
}
