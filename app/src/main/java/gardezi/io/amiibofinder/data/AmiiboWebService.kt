package gardezi.io.amiibofinder.data

import android.app.Application

import gardezi.io.amiibofinder.R
import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AmiiboWebService internal constructor(application: Application) {

    private val api = Retrofit.Builder()
            .baseUrl(application.resources.getString(R.string.base_url))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AmiiboApi::class.java)

    fun getAmiibosByName(name: String): Observable<List<Amiibo>> {
        return api.getAmiiboByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map({ it.amiibo })
    }
}
