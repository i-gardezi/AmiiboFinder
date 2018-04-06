package gardezi.io.amiibofinder;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import gardezi.io.amiibofinder.data.AmiiboRepository;
import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AmiiboViewModel extends AndroidViewModel {

    private MutableLiveData<List<Amiibo>> amiibosByName = new MutableLiveData<>();

    private AmiiboRepository repository;

    public AmiiboViewModel(@NonNull Application application) {
        super(application);
        repository = new AmiiboRepository(application);
    }

    public MutableLiveData<List<Amiibo>> getAmiibosByName(String name) {
        repository.getAmiibosByName(name).subscribe(new Observer<List<Amiibo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Amiibo> amiibos) {
                amiibosByName.postValue(amiibos);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return amiibosByName;
    }
}
