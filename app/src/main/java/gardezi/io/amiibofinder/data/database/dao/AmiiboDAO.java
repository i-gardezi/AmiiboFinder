package gardezi.io.amiibofinder.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import gardezi.io.amiibofinder.model.Amiibo;
import io.reactivex.Flowable;

@Dao
public interface AmiiboDAO {

        @Query("SELECT * FROM amiibo")
        Flowable<List<Amiibo>> getAll();

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(List<Amiibo> amiibos);

}
