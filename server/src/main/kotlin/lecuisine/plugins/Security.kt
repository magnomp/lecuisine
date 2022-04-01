package lecuisine.plugins

import io.ktor.server.auth.*
import io.ktor.util.*
import io.ktor.server.auth.jwt.*
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*

private const val jwtAudience = "LeCuisine"

fun Application.configureSecurity(jwtSecret: String) {
    
    authentication {
            jwt {
                realm = "Access to LeCuisine app"
                verifier(
                    JWT
                        .require(Algorithm.HMAC256("secret"))
                        .withAudience(jwtAudience)
                        .withIssuer("LeCuisine")
                        .build()
                )
                validate { credential ->
                    if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
                }
            }
        }

}
