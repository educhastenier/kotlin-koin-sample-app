import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.inject

/**
 * HelloComponent - Application Class.
 * Uses HelloService
 */
class HelloComponent : KoinComponent {
    // Inject HelloService
    val helloService by inject<HelloService>()

    // display our data
    fun sayHello() = println(helloService.getHelloMessage())
}

fun main() {
    startKoin {
        // use Koin logger
        printLogger()
        // declare modules
        modules(helloModule)
    }

    HelloComponent().sayHello()

    stopKoin()
}