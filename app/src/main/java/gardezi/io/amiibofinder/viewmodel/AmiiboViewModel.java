package gardezi.io.amiibofinder.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import gardezi.io.amiibofinder.data.AmiiboRepository;
import gardezi.io.amiibofinder.model.Amiibo;
import gardezi.io.amiibofinder.rx.RxAndroidViewModel;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AmiiboViewModel extends RxAndroidViewModel {

    private MutableLiveData<List<Amiibo>> amiibos = new MutableLiveData<>();

    private AmiiboRepository repository;

    private boolean isQueryingAmiibos;

    public AmiiboViewModel(@NonNull Application application) {
        super(application);
        repository = new AmiiboRepository(application);
    }

    public void getAmiibosByName(String name) {
        repository.getAmiibosByName(name).subscribe(new Observer<List<Amiibo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
                if (isQueryingAmiibos) {
                    clearDisposables();
                }
                isQueryingAmiibos = true;
            }

            @Override
            public void onNext(List<Amiibo> amiibos) {
                AmiiboViewModel.this.amiibos.postValue(amiibos);
            }

            @Override
            public void onError(Throwable e) {
                amiibos.postValue(null);
                isQueryingAmiibos = false;
                Log.e("AmiiboViewModel", "Error retrieving Amiibos by Name", e);

            }

            @Override
            public void onComplete() {
                isQueryingAmiibos = false;
            }
        });
    }

    public MutableLiveData<List<Amiibo>> getAmiibos() {
        return amiibos;
    }


}
