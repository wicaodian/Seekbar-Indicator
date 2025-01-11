package com.wico.indicatorseekbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initCreate()
    }

    protected open fun initCreate() {
    }

    abstract val layoutResId: Int
}
