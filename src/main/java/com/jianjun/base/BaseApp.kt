package com.jianjun.base

import androidx.multidex.MultiDexApplication

open class BaseApp : MultiDexApplication() {


    override fun onCreate() {
        globalApp = this
        super.onCreate()
    }

    companion object {
        private lateinit var globalApp: BaseApp
        fun getApp() = globalApp
    }
}