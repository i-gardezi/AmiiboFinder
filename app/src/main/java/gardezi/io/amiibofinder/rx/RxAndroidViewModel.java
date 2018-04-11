package gardezi.io.amiibofinder.rx;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class RxAndroidViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    public RxAndroidViewModel() {

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
