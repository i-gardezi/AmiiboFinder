package gardezi.io.amiibofinder.rx

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private val disposables = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        this.disposables.add(disposable)
    }

    protected fun clearDisposables() {
        this.disposables.clear()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
