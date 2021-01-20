package lokovsek.pir.loadingpivo.ui

import android.app.Application
import android.os.Build
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimberLogger()
    }

    private fun initTimberLogger() {
        Timber.plant(Timber.DebugTree())
    }
}