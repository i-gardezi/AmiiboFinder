package gardezi.io.amiibofinder.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import gardezi.io.amiibofinder.data.AmiiboRepository;
import gardezi.io.amiibofinder.model.Amiibo;
import gardezi.io.amiibofinder.rx.RxAndroidViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class AmiiboViewModel extends RxAndroidViewModel {

    private MutableLiveData<List<Amiibo>> amiibos = new MutableLiveData<>();

    private final AmiiboRepository repository;

    private boolean isQueryingAmiibos;

    @Inject
    public AmiiboViewModel(AmiiboRepository amiiboRepository) {
        repository = amiiboRepository;
    }

    public void getAmiibosByName(String name) {
        repository.getAmiibosByName(name).subscribe(new SingleObserver<List<Amiibo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
                if (isQueryingAmiibos) {
                    clearDisposables();
                }
                isQueryingAmiibos = true;
            }

            @Override
            public void onSuccess(List<Amiibo> amiibos) {
                AmiiboViewModel.this.amiibos.postValue(amiibos);
            }

            @Override
            public void onError(Throwable e) {
                amiibos.postValue(null);
                isQueryingAmiibos = false;
                Log.e("AmiiboViewModel", "Error retrieving Amiibos by Name", e);
            }
        });
    }

    public MutableLiveData<List<Amiibo>> getAmiibos() {
        return amiibos;
    }


}
