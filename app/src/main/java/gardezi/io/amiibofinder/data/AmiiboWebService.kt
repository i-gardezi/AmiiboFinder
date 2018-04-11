package gardezi.io.amiibofinder.data

import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class AmiiboWebService(retrofit: Retrofit) {

    private val api: AmiiboApi

    init {
        api = retrofit.create(AmiiboApi::class.java)
    }

    internal fun getAmiibosByName(name: String): Single<List<Amiibo>> {
        return api.getAmiiboByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map({ it.amiibo })
    }
}
