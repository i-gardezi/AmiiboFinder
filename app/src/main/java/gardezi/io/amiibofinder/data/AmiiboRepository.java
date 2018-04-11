package gardezi.io.amiibofinder.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO;
import gardezi.io.amiibofinder.data.network.AmiiboWebService;
import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Single;

@Singleton
public class AmiiboRepository {

    private AmiiboWebService webService;
    private AmiiboDAO dao;
    private boolean isOffline;

    @Inject
    public AmiiboRepository(AmiiboWebService amiiboWebService, AmiiboDAO amiiboDAO) {
        this.webService = amiiboWebService;
        this.dao = amiiboDAO;
    }


    public Single<List<Amiibo>> getAmiibosByName(String name) {
        if (!isOffline) {
            return dao.getAll().firstOrError();
        } else {
            return webService.getAmiibosByName(name).flatMap(amiibos -> {
                cacheAmiibos(amiibos);
                return Single.just(amiibos);
            });
        }
    }

    private void cacheAmiibos(List<Amiibo> data) {
        dao.insertAll(data);
    }

}
