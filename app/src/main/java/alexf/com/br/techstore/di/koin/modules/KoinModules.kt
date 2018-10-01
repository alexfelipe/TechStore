package alexf.com.br.techstore.di.koin.modules

import alexf.com.br.techstore.database.AppDatabase
import alexf.com.br.techstore.database.dao.ProductDao
import alexf.com.br.techstore.ui.recyclerview.ProductsListAdapter
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import org.koin.dsl.module.module

val dbModule = module {
    single { Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "techstore-database")
            .build()}
    single { get<AppDatabase>().productDao() }
}

val uiModule = module {
    factory { ProductsListAdapter(context = get()) }
}