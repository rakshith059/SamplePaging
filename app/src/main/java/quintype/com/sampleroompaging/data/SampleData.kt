package quintype.com.sampleroompaging.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created SampleRoomPaging by rakshith on 6/1/18.
 */

@Entity
data class SampleData(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)