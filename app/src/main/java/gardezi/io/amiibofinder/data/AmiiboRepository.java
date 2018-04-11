package gardezi.io.amiibofinder.data;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Single;

@Singleton
public class AmiiboRepository {

    private AmiiboWebService webService;

    @Inject
    public AmiiboRepository(AmiiboWebService amiiboWebService) {
        this.webService = amiiboWebService;
    }

    public Single<List<Amiibo>> getAmiibosByName(String name) {
        return webService.getAmiibosByName(name);
    }

}
