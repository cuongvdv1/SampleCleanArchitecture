package com.example.samplecleanarchitecture.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import com.example.samplecleanarchitecture.base.BaseDialog
import com.example.samplecleanarchitecture.databinding.LoadingDialogBinding

class LoadingDialog(context: Context): BaseDialog<LoadingDialogBinding>(context) {

    override fun setBinding(layoutInflater: LayoutInflater): LoadingDialogBinding {
        return LoadingDialogBinding.inflate(layoutInflater)
    }
}
