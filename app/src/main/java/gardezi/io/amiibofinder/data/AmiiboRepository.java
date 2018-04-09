package gardezi.io.amiibofinder.data;

import android.app.Application;

import java.util.List;

import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Observable;
import io.reactivex.Single;

public class AmiiboRepository {

    AmiiboWebService webService;

    public AmiiboRepository(Application application) {
        this.webService = new AmiiboWebService(application);
    }

    public Single<List<Amiibo>> getAmiibosByName(String name) {
        return webService.getAmiibosByName(name);
    }

}
