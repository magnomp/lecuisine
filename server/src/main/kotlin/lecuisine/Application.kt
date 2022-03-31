package lecuisine

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import lecuisine.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureAdministration()
        configureRouting()
        configureSerialization()
        configureSecurity()
        configureHTTP()
    }.start(wait = true)
}
