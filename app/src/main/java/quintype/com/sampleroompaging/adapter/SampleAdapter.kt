package quintype.com.sampleroompaging.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.util.DiffUtil.ItemCallback
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import quintype.com.sampleroompaging.data.SampleData
import quintype.com.sampleroompaging.holder.SampleViewHolder
import quintype.com.sampleroompaging.viewmodel.SampleViewModel

/**
 * Created SampleRoomPaging by rakshith on 6/1/18.
 */

class SampleAdapter : PagedListAdapter<SampleData, SampleViewHolder>(diffCallback) {

    companion object {
        var diffCallback = object : DiffUtil.ItemCallback<SampleData>() {
            override fun areItemsTheSame(oldItem: SampleData?, newItem: SampleData?): Boolean {
                return oldItem?.id == newItem?.id
            }

            override fun areContentsTheSame(oldItem: SampleData?, newItem: SampleData?): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder = SampleViewHolder(parent)

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bindtTo(getItem(position))
    }

}