package alexf.com.br.techstore.database

import android.content.Context
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
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
        val dbInstances = mutableListOf<AppDatabase>()
        repeat(10) {
            thread(start = true) {
                var element = Database.instance(context)
                dbInstances.add(element)
            }
        }
        Thread.sleep(500)

        if (dbInstances.isNotEmpty()) {
            val iterator = dbInstances.iterator()
            val first = iterator.next()
            if (iterator.hasNext()) {
                assertThat(first, equalTo(iterator.next()))
            }
        }
    }

}