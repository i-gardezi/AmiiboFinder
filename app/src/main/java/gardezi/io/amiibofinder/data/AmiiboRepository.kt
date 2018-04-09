package gardezi.io.amiibofinder.data

import android.app.Application

import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Single

class AmiiboRepository(application: Application) {

    private var webService = AmiiboWebService(application)

    fun getAmiibosByName(name: String): Single<List<Amiibo>> {
        return webService.getAmiibosByName(name)
    }

}
