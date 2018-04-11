package gardezi.io.amiibofinder.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import gardezi.io.amiibofinder.data.AmiiboRepository
import gardezi.io.amiibofinder.model.Amiibo
import gardezi.io.amiibofinder.rx.RxAndroidViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AmiiboViewModel @Inject
constructor(private val repository: AmiiboRepository) : RxAndroidViewModel() {

    val amiibos = MutableLiveData<List<Amiibo>>()

    private var isQueryingAmiibos: Boolean = false

    fun getAmiibosByName(name: String) {
        repository.getAmiibosByName(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Amiibo>> {
                    override fun onSubscribe(d: Disposable) {
                        addDisposable(d)
                        if (isQueryingAmiibos) {
                            clearDisposables()
                        }
                        isQueryingAmiibos = true
                    }

                    override fun onSuccess(amiibos: List<Amiibo>) {
                        this@AmiiboViewModel.amiibos.postValue(amiibos)
                    }

                    override fun onError(e: Throwable) {
                        amiibos.postValue(null)
                        isQueryingAmiibos = false
                        Log.e("AmiiboViewModel", "Error retrieving Amiibos by Name", e)
                    }
                })
    }


}