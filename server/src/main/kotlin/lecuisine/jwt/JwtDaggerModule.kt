package lecuisine.jwt

import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Named

@Module
class JwtDaggerModule {
    @Named("jwt.secret")
    @Provides
    fun provideJwtSecret(): String = UUID.randomUUID().toString()
}