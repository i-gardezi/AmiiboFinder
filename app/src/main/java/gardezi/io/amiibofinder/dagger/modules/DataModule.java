package gardezi.io.amiibofinder.dagger.modules;

import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gardezi.io.amiibofinder.AmiiboApplication;
import gardezi.io.amiibofinder.data.AmiiboRepository;
import gardezi.io.amiibofinder.data.database.AppDatabase;
import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO;
import gardezi.io.amiibofinder.data.network.AmiiboApi;
import gardezi.io.amiibofinder.data.network.AmiiboWebService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @Singleton
    AppDatabase providesAppDatabase() {
        return Room.databaseBuilder(AmiiboApplication.getInstance(), AppDatabase.class, "AmiiboDatabase").build();
    }

    @Provides
    @Singleton
    AmiiboDAO providesAmiiboDao() {
        return providesAppDatabase().amiiboDAO();
    }

    @Singleton
    @Provides
    AmiiboRepository provideAmiiboRepository() {
        return new AmiiboRepository(provideAmiiboWebService(), providesAmiiboDao());
    }

    @Singleton
    @Provides
    AmiiboWebService provideAmiiboWebService() {
        return new AmiiboWebService(provideRetrofit());
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(AmiiboApi.HTTPS_API_AMIIBO_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
