package com.example.samplecleanarchitecture.ui.department

import com.example.samplecleanarchitecture.base.BaseActivity
import com.example.samplecleanarchitecture.databinding.ActivityListDataBinding
import com.example.samplecleanarchitecture.ui.department.adapter.DepartmentAdapter
import com.example.samplecleanarchitecture.ui.department.viewModel.DepartmentViewModel
import com.example.samplecleanarchitecture.ui.employee.EmployeeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DepartmentActivity : BaseActivity<ActivityListDataBinding>(ActivityListDataBinding::inflate) {

    private val adapter by lazy { DepartmentAdapter() }
    private val viewModel by viewModel<DepartmentViewModel>()

    override fun initView() {
        viewBinding.rvData.adapter = adapter
    }

    override fun bindView() {
        adapter.setOnItemClickListener {
            startActivity(EmployeeActivity.getIntent(this, it.code))
        }
    }

    override fun bindViewModel() {
        viewModel.department.observe(this) {
            adapter.submitList(it)
        }

        viewModel.isLoading.observe(this) {
            if (it) showDialog() else hideDialog()
        }

        viewModel.getListDepartment()
    }
}
