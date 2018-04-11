package gardezi.io.amiibofinder.data;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

import gardezi.io.amiibofinder.data.database.AppDatabase;
import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO;
import gardezi.io.amiibofinder.data.network.AmiiboWebService;
import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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
