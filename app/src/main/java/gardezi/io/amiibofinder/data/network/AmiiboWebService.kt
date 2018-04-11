package gardezi.io.amiibofinder.data.network

import gardezi.io.amiibofinder.data.AmiiboApi
import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class AmiiboWebService(retrofit: Retrofit) {

    private val api: AmiiboApi = retrofit.create(AmiiboApi::class.java)

    fun getAmiibosByName(name: String): Single<List<Amiibo>> {
        return api.getAmiiboByName(name)
                .subscribeOn(Schedulers.io())
                .map({ it.amiibo })
    }
}