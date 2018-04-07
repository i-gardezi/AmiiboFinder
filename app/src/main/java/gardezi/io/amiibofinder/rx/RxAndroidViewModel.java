package gardezi.io.amiibofinder.rx;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class RxAndroidViewModel extends AndroidViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    public RxAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    protected void addDisposable(Disposable disposable) {
        this.disposables.add(disposable);
    }

    protected void clearDisposables() {
        this.disposables.clear();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
