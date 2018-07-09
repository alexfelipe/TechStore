package alexf.com.br.techstore.database

import android.content.Context
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import kotlin.concurrent.thread

@RunWith(MockitoJUnitRunner::class)
class DatabaseTest {

    @Mock
    private lateinit var context: Context

    @Test
    fun `should get the same instance of Database when run threads simultaneously`() {
        repeat(10) {
            thread(start = true) {
                var element = Database.instance(context)
                println(element)
            }
        }
        Thread.sleep(500)
    }

}