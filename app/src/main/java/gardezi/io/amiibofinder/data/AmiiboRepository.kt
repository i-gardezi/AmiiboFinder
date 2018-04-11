package gardezi.io.amiibofinder.data

import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AmiiboRepository @Inject
constructor(private val webService: AmiiboWebService) {

    fun getAmiibosByName(name: String): Single<List<Amiibo>> {
        return webService.getAmiibosByName(name)
    }

}
