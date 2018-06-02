package quintype.com.sampleroompaging.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import quintype.com.sampleroompaging.data.SampleData
import quintype.com.sampleroompaging.database.SampleDB
import quintype.com.sampleroompaging.ioThread

/**
 * Created SampleRoomPaging by rakshith on 6/1/18.
 */

class SampleViewModel(app: Application) : AndroidViewModel(app) {

    val dao = SampleDB.get(app).sampleDao()

    companion object {
        val PAGESIZE = 30
        val PLACEHOLDER_ENABALED = true
        val PREFETCH = 5
    }

    val allSamples = LivePagedListBuilder(dao.allSampleByName(), PagedList.Config.Builder()
            .setPageSize(PAGESIZE)
            .setEnablePlaceholders(PLACEHOLDER_ENABALED)
            .setPrefetchDistance(PREFETCH)
            .build()).build()

    fun insert(text: String) = ioThread {
        dao.insert(SampleData(id = 0, name = text))
    }

    fun remove(sampleData: SampleData) = ioThread {
        dao.delete(sampleData)
    }
}