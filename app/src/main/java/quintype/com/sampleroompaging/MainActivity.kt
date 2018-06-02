package quintype.com.sampleroompaging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import quintype.com.sampleroompaging.adapter.SampleAdapter
import quintype.com.sampleroompaging.holder.SampleViewHolder
import quintype.com.sampleroompaging.viewmodel.SampleViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.activity_main_btn_add -> {
                var name = activity_main_et_name?.text?.toString()
                if (!TextUtils.isEmpty(name))
                    viewModel.insert(name as String)
            }
        }
    }

    private var SAMPLE_URL: String = ""
    private val headerMap = HashMap<String, String>()
    private val paramMap = HashMap<String, String>()

//    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
//        ViewModelProviders.of(this).get(SampleViewModel::class.java)
//    }

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { ViewModelProviders.of(this).get(SampleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleAdapter = SampleAdapter()
        activity_main_rv_list?.adapter = sampleAdapter

        viewModel.allSamples.observe(this, Observer(sampleAdapter::submitList))

        activity_main_btn_add.setOnClickListener(this)

        initSwipeToDelete()

//        var sampleApi = NetworkVolleyRequest(
//                NetworkVolleyRequest.RequestMethod.GET,
//                SAMPLE_URL,
//                String::class.java,
//                headerMap as HashMap,
//                paramMap,
//                object : NetworkVolleyRequest.Callback<Any> {
//                    override fun onError(errorCode: Int, errorMessage: String) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//
//                    override fun onSuccess(response: Any) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//                }, NetworkVolleyRequest.ContentType.JSON
//        ).execute()
    }

    private fun initSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

            override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                (viewHolder as SampleViewHolder)?.sampleData?.let { viewModel.remove(it) }
            }
        }).attachToRecyclerView(activity_main_rv_list)
    }
}
