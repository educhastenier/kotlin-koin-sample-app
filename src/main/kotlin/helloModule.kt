import org.koin.dsl.module

val helloModule = module {

    // Define our 'beans' as singletons:
    single { HelloMessageData("Salut tout le monde à la démo !") }
    single { HelloServiceImpl(get()) as HelloService }

    // alternative declaration:
    // single<HelloService> { HelloServiceImpl(get()) }

}