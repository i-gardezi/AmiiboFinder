package gardezi.io.amiibofinder.data;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AmiiboApi {

    String HTTPS_API_AMIIBO_URL = "http://www.amiiboapi.com/api/";

    @GET("amiibo/")
    Single<AmiiboPayload> getAmiiboByName(@Query("name") String name);

}
