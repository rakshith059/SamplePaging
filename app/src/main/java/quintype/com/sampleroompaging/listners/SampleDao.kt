package quintype.com.sampleroompaging.listners

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import quintype.com.sampleroompaging.data.SampleData

/**
 * Created SampleRoomPaging by rakshith on 6/1/18.
 */

@Dao
interface SampleDao {
    @Query("SELECT * FROM SampleData ORDER BY name COLLATE NOCASE ASC")
    fun allSampleByName(): DataSource.Factory<Int, SampleData>

    @Insert
    fun insert(sampleDatas: List<SampleData>)

    @Insert()
    fun insert(sampleData: SampleData)

    @Delete
    fun delete(sampleData: SampleData)
}