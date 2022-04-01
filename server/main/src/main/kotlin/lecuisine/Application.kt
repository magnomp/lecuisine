package lecuisine

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import lecuisine.plugins.*

fun main() {
    val leCuisine: LeCuisine = DaggerLeCuisine.create()
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureAdministration()
        configureRouting()
        configureSerialization()
        configureSecurity(leCuisine.jwtSecret())
        configureHTTP()
    }.start(wait = true)
}
