package gardezi.io.amiibofinder.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import gardezi.io.amiibofinder.data.database.dao.AmiiboDAO
import gardezi.io.amiibofinder.model.Amiibo

@Database(entities = arrayOf(Amiibo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun amiiboDAO(): AmiiboDAO

}
