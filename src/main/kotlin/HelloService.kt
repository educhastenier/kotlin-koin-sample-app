/**
 * Hello Service - interface
 */
interface HelloService {
    fun getHelloMessage(): String
}

/**
 * Hello Service Impl
 * Will use HelloMessageData data
 */
class HelloServiceImpl(private val helloMessageData: HelloMessageData) : HelloService {
    override fun getHelloMessage() = "Hey, ${helloMessageData.message}"
}