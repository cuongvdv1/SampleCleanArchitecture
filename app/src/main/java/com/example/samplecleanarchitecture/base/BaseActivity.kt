package com.example.samplecleanarchitecture.base

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding
import com.example.samplecleanarchitecture.ui.dialog.LoadingDialog

abstract class BaseActivity<VB : ViewBinding>(inflater: (LayoutInflater) -> VB) : AppCompatActivity() {

    protected val viewBinding by lazy { inflater(layoutInflater) }
    protected open val belowStatusBar = true
    private val loadingDialog by lazy { LoadingDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        hideNavigationBar()
        if (belowStatusBar) {
            drawBelowStatusBar()
        }
        initView()
        bindView()
        bindViewModel()
    }

    open fun initView() {}

    open fun bindView() {}

    open fun bindViewModel() {}

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            hideNavigationBarInLowerAndroid()
        }
    }

    private fun hideNavigationBar() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            hideNavigationBarInLowerAndroid()
        } else {
            WindowInsetsControllerCompat(window, viewBinding.root).let { controller ->
                controller.hide(WindowInsetsCompat.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }

    private fun hideNavigationBarInLowerAndroid() {
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }

    private fun drawBelowStatusBar() {
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding.root) { v, insets ->
            val imeVisible = insets.isVisible(WindowInsetsCompat.Type.ime())
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
            val statusBarsInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            val insetBottom = if (imeVisible) imeInsets.bottom else statusBarsInsets.bottom
            v.setPadding(statusBarsInsets.left, statusBarsInsets.top, statusBarsInsets.right, insetBottom)
            insets
        }
    }

    protected fun showDialog() {
        if (loadingDialog.isShowing.not()) loadingDialog.show()
    }

    protected fun hideDialog() {
        if (loadingDialog.isShowing) loadingDialog.dismiss()
    }
}
