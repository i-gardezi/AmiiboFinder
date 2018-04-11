package gardezi.io.amiibofinder.data

import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO
import gardezi.io.amiibofinder.data.network.AmiiboWebService
import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AmiiboRepository @Inject
constructor(private val webService: AmiiboWebService, private val dao: AmiiboDAO) {


    fun getAmiibosByName(name: String): Single<List<Amiibo>> {
        return webService.getAmiibosByName(name).flatMap { amiibos ->
            cacheAmiibos(amiibos)
            Single.just(amiibos)
        }
    }

    private fun cacheAmiibos(data: List<Amiibo>) {
        dao.insertAll(data)
    }

}
