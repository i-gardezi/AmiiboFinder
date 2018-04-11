package gardezi.io.amiibofinder.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Amiibo(
        @PrimaryKey val uid: Int,
        @ColumnInfo(name = "amiibo_series") val amiiboSeries: String,
        @ColumnInfo(name = "character") val character: String,
        @ColumnInfo(name = "game_series") val gameSeries: String,
        @ColumnInfo(name = "head") val head: String,
        @ColumnInfo(name = "image") val image: String,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "tail") val tail: String,
        @ColumnInfo(name = "type") val type: String)