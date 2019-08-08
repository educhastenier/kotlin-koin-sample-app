import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class HelloAppTest : AutoCloseKoinTest() {

    private val model: HelloMessageData by inject()
    private val service: HelloService by inject()

    @Before
    fun before() {
        startKoin {
            printLogger()
            modules(helloModule)
        }
    }

    @Test
    fun testKoinComponents() {
        // given:
        val helloApp = HelloComponent()

        // when:
        helloApp.sayHello()

        // then:
        assertThat(service).isEqualTo(helloApp.helloService)
        assertThat("Hey, ${model.message}").isEqualTo(service.getHelloMessage())
    }

}