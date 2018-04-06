package gardezi.io.amiibofinder.data;

import android.app.Application;

import java.util.List;

import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Observable;

public class AmiiboRepository {

    AmiiboWebService webService;

    public AmiiboRepository(Application application) {
        this.webService = new AmiiboWebService(application);
    }

    public Observable<List<Amiibo>> getAmiibosByName(String name) {
        return webService.getAmiiboByName(name);
    }
}
