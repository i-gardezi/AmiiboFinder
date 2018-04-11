package gardezi.io.amiibofinder.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AmiiboApi {

    @GET("amiibo/")
    fun getAmiiboByName(@Query("name") name: String): Single<AmiiboPayload>

    companion object {
        val baseUrl = "http://www.amiiboapi.com/api/"
    }

}
