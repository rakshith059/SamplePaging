package quintype.com.sampleroompaging.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import quintype.com.sampleroompaging.R
import quintype.com.sampleroompaging.data.SampleData

/**
 * Created SampleRoomPaging by rakshith on 6/1/18.
 */
class SampleViewHolder(parent: ViewGroup?) : RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.sample_row, parent, false)) {
    private val tvSampleText = itemView?.findViewById<TextView>(R.id.sample_row_tv_sample_text)
    var sampleData: SampleData? = null

    fun bindtTo(sampleData: SampleData?) {
        this.sampleData = sampleData
        tvSampleText?.text = sampleData?.name
    }
}