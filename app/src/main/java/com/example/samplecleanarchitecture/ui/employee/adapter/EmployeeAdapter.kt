package com.example.samplecleanarchitecture.ui.employee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.samplecleanarchitecture.R
import com.example.samplecleanarchitecture.base.BaseListAdapter
import com.example.samplecleanarchitecture.base.BaseViewHolder
import com.example.samplecleanarchitecture.databinding.ItemDepartmentBinding
import com.example.samplecleanarchitecture.ui.employee.model.Employee
import com.example.samplecleanarchitecture.utils.loadImage
import com.example.samplecleanarchitecture.utils.setCornerRadius
import com.example.samplecleanarchitecture.utils.toDp

class EmployeeAdapter: BaseListAdapter<Employee, ItemDepartmentBinding, EmployeeAdapter.EmployeeViewHolder>(
diffCallback
) {

    private var onItemClick: (Employee) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EmployeeViewHolder(ItemDepartmentBinding.inflate(layoutInflater, parent, false))
    }

    fun setOnItemClickListener(onItemClick: (Employee) -> Unit) {
        this.onItemClick = onItemClick
    }

    inner class EmployeeViewHolder(binding: ItemDepartmentBinding) :
        BaseViewHolder<Employee, ItemDepartmentBinding>(binding) {

        init {
            binding.root.setOnClickListener {
                data?.let { onItemClick(it) }
            }
        }

        override fun onBindData(data: Employee) {
            super.onBindData(data)
            binding.name.text = data.name
            binding.image.loadImage(data.image, R.drawable.landscape_placeholder)
            binding.image.setCornerRadius(topLeft = 8f.toDp(), topRight = 8f.toDp())
            if (data.isSelected) {
                binding.bgView.setBackgroundResource(R.drawable.bg_8_stroke)
            } else {
                binding.bgView.background = null
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Employee>() {
            override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
                return oldItem == newItem
            }
        }
    }
}
