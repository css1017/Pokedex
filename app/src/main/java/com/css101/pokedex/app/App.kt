package com.css101.pokedex.app

import android.app.Application
import com.css101.pokedex.di.appModule
import com.css101.pokedex.di.dataModule
import com.css101.pokedex.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, domainModule, dataModule)
        }
    }
}