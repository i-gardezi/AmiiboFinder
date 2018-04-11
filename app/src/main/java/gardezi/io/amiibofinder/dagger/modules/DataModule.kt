package gardezi.io.amiibofinder.dagger.modules

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import gardezi.io.amiibofinder.AmiiboApplication
import gardezi.io.amiibofinder.data.AmiiboApi
import gardezi.io.amiibofinder.data.AmiiboRepository
import gardezi.io.amiibofinder.data.database.AppDatabase
import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO
import gardezi.io.amiibofinder.data.network.AmiiboWebService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    internal fun providesAppDatabase(): AppDatabase {
        return Room.databaseBuilder(AmiiboApplication.instance!!, AppDatabase::class.java, "AmiiboDatabase").build()
    }

    @Provides
    @Singleton
    internal fun providesAmiiboDao(): AmiiboDAO {
        return providesAppDatabase().amiiboDAO()
    }

    @Singleton
    @Provides
    internal fun provideAmiiboRepository(): AmiiboRepository {
        return AmiiboRepository(provideAmiiboWebService(), providesAmiiboDao())
    }

    @Singleton
    @Provides
    internal fun provideAmiiboWebService(): AmiiboWebService {
        return AmiiboWebService(provideRetrofit())
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(AmiiboApi.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
