package alexf.com.br.techstore.database

import alexf.com.br.techstore.di.koin.modules.dbModule
import android.content.Context
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.with
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.concurrent.thread

@RunWith(MockitoJUnitRunner::class)
class DatabaseTest : KoinTest {

    private val dbInstace: AppDatabase by inject()

    @Test
    fun `should get the same instance of Database when run threads simultaneously`() {
        startKoin(listOf(dbModule)) with (mock(Context::class.java))
        repeat(10) {
            thread(start = true) {
                println(dbInstace)
            }
        }
        Thread.sleep(500)
    }

}