package com.jianjun.base

import android.content.Context
import androidx.multidex.MultiDexApplication

open class BaseApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        globalApp = this
    }

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        private lateinit var globalApp: BaseApp
        fun getApp() = globalApp
    }
}