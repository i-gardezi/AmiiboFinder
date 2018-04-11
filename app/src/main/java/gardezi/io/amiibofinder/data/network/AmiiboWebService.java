package gardezi.io.amiibofinder.data.network;

import java.util.List;

import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AmiiboWebService {

    private AmiiboApi api;

    public AmiiboWebService(Retrofit retrofit) {
        api = retrofit.create(AmiiboApi.class);
    }

    public Single<List<Amiibo>> getAmiibosByName(String name) {
        return api.getAmiiboByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(AmiiboPayload::getAmiibo);
    }
}
