package com.jianjun.base.compontent

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity : AppCompatActivity() {

    private inline fun <reified T : ViewModel> AppCompatActivity.viewModels() = lazy {
        ViewModelProvider(this).get(T::class.java)
    }
}