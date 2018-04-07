package gardezi.io.amiibofinder.data;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AmiiboApi {

    @GET("amiibo/")
    Observable<AmiiboPayload> getAmiiboByName(@Query("name") String name);

}
