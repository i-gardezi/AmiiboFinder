package gardezi.io.amiibofinder.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.util.Log

import gardezi.io.amiibofinder.data.AmiiboRepository
import gardezi.io.amiibofinder.model.Amiibo
import gardezi.io.amiibofinder.rx.RxAndroidViewModel
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AmiiboViewModel @Inject constructor(var repository: AmiiboRepository) : RxAndroidViewModel() {

    val amiibos = MutableLiveData<List<Amiibo>>()

    private var isQueryingAmiibos = false

    fun getAmiibosByName(name: String) {
        repository.getAmiibosByName(name).subscribe(object : SingleObserver<List<Amiibo>> {
            override fun onSubscribe(d: Disposable) {
                addDisposable(d)
                if (isQueryingAmiibos) {
                    clearDisposables()
                }
                isQueryingAmiibos = true
            }

            override fun onError(e: Throwable) {
                amiibos.postValue(null)
                isQueryingAmiibos = false
                Log.e("AmiiboViewModel", "Error retrieving Amiibos by Name", e)

            }

            override fun onSuccess(t: List<Amiibo>) {
                this@AmiiboViewModel.amiibos.postValue(t)
                isQueryingAmiibos = false
            }

        })
    }


}
