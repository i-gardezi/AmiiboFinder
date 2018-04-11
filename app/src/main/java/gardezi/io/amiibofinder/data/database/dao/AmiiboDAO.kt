package gardezi.io.amiibofinder.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import gardezi.io.amiibofinder.model.Amiibo
import io.reactivex.Flowable

@Dao
interface AmiiboDAO {

    @get:Query("SELECT * FROM amiibo")
    val all: Flowable<List<Amiibo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(amiibos: List<Amiibo>)

}
