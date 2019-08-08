
import org.junit.After
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class SimpleTest : KoinTest {

    // Lazy inject property
    private val componentA: ComponentA by inject()

    @After
    fun closeAfterTest() {
        stopKoin()
    }

    // use it in your tests :)
    @Test
    fun `make a test with Koin`() {
        startKoin { modules(appModule) }

        // make use of componentA:
        println(componentA)
    }

}

data class ComponentA(val name: String = "A Component")

// Koin Configuration:
val appModule = module {
    single { ComponentA() }
}