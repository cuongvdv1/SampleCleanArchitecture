package com.example.samplecleanarchitecture.ui.employee

import android.content.Context
import android.content.Intent
import androidx.core.view.isVisible
import com.example.samplecleanarchitecture.R
import com.example.samplecleanarchitecture.base.BaseActivity
import com.example.samplecleanarchitecture.databinding.ActivityListDataBinding
import com.example.samplecleanarchitecture.ui.employee.adapter.EmployeeAdapter
import com.example.samplecleanarchitecture.ui.employee.viewModel.EmployeeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeActivity: BaseActivity<ActivityListDataBinding>(ActivityListDataBinding::inflate)  {

    private val adapter by lazy { EmployeeAdapter() }
    private val viewModel by viewModel<EmployeeViewModel>()

    override fun initView() {
        viewBinding.rvData.adapter = adapter
        viewBinding.title.text = getString(R.string.employee)
    }

    override fun bindView() {
        adapter.setOnItemClickListener {
            viewModel.selectEmployee(it)
        }

        viewBinding.deleteBtn.setOnClickListener {
            viewModel.deleteEmployee()
        }
    }

    override fun bindViewModel() {
        viewModel.employee.observe(this) { employee ->
            adapter.submitList(employee)
            val showDelete = employee.any { it.isSelected }
            viewBinding.deleteBtn.isVisible = showDelete
        }

        viewModel.isLoading.observe(this) {
            if (it) showDialog() else hideDialog()
        }

        intent.getStringExtra(KEY_DEPARTMENT_CODE)?.let {
            viewModel.getListEmployee(it)
        }
    }

    companion object {
        private const val KEY_DEPARTMENT_CODE = "KEY_DEPARTMENT_CODE"

        fun getIntent(context: Context, departmentCode: String): Intent {
            return Intent(context, EmployeeActivity::class.java).apply {
                putExtra(KEY_DEPARTMENT_CODE, departmentCode)
            }
        }
    }
}
