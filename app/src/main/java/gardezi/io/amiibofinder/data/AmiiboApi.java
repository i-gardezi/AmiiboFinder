package gardezi.io.amiibofinder.data;


import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AmiiboApi {

    @GET("amiibo/")
    Single<AmiiboPayload> getAmiiboByName(@Query("name") String name);

}
