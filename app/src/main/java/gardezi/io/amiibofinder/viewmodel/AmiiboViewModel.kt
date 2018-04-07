package gardezi.io.amiibofinder.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.util.Log

import gardezi.io.amiibofinder.data.AmiiboRepository
import gardezi.io.amiibofinder.model.Amiibo
import gardezi.io.amiibofinder.rx.RxAndroidViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class AmiiboViewModel(application: Application) : RxAndroidViewModel(application) {

    val amiibos = MutableLiveData<List<Amiibo>>()

    private val repository = AmiiboRepository(application)

    private var isQueryingAmiibos: Boolean = false

    fun getAmiibosByName(name: String) {
        repository.getAmiibosByName(name).subscribe(object : Observer<List<Amiibo>> {
            override fun onSubscribe(d: Disposable) {
                addDisposable(d)
                if (isQueryingAmiibos) {
                    clearDisposables()
                }
                isQueryingAmiibos = true
            }

            override fun onNext(amiibos: List<Amiibo>) {
                this@AmiiboViewModel.amiibos.postValue(amiibos)
            }

            override fun onError(e: Throwable) {
                amiibos.postValue(null)
                isQueryingAmiibos = false
                Log.e("AmiiboViewModel", "Error retrieving Amiibos by Name", e)

            }

            override fun onComplete() {
                isQueryingAmiibos = false
            }
        })
    }


}
