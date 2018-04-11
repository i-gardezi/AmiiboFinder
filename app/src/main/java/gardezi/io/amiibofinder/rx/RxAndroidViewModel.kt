package gardezi.io.amiibofinder.rx

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxAndroidViewModel : ViewModel() {

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
