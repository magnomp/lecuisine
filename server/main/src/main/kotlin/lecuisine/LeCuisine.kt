package lecuisine

import dagger.Component
import lecuisine.jwt.JwtDaggerModule
import javax.inject.Named

@Component(modules=[JwtDaggerModule::class])
interface LeCuisine {
    @Named("jwt.secret") fun jwtSecret(): String
}