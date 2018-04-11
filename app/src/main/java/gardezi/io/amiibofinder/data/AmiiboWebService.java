package gardezi.io.amiibofinder.data;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import gardezi.io.amiibofinder.R;
import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AmiiboWebService {

    private AmiiboApi api;

    public AmiiboWebService(Retrofit retrofit) {
        api = retrofit.create(AmiiboApi.class);
    }

    Single<List<Amiibo>> getAmiibosByName(String name) {
        return api.getAmiiboByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(AmiiboPayload::getAmiibo);
    }
}
