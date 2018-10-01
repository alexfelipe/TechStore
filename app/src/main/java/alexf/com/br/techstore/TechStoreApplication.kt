package alexf.com.br.techstore

import alexf.com.br.techstore.di.koin.modules.dbModule
import alexf.com.br.techstore.di.koin.modules.uiModule
import android.app.Application
import org.koin.android.ext.android.startKoin

class TechStoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(dbModule, uiModule))
    }

}