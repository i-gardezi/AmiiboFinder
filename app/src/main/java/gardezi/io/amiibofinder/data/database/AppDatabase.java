package gardezi.io.amiibofinder.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO;
import gardezi.io.amiibofinder.model.Amiibo;

@Database(entities = {Amiibo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AmiiboDAO amiiboDAO();

}
