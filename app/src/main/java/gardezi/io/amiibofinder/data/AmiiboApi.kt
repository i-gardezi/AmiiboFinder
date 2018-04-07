package gardezi.io.amiibofinder.data


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AmiiboApi {

    @GET("amiibo/")
    fun getAmiiboByName(@Query("name") name: String): Observable<AmiiboPayload>

}
