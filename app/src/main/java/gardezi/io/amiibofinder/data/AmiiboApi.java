package gardezi.io.amiibofinder.data;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AmiiboApi {

    @GET("api/amiibo/")
    Observable<AmiiboPayload> getAmiiboByName(@Query("name") String name);

    @GET("api/amiibo/")
    Observable<AmiiboPayload> getAmiiboByCharacter(@Query("character") String character);

    @GET("api/gameseries")
    Observable<GameSeriesPayload> getAllGameSeries();
}
