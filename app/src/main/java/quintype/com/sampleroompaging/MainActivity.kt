package quintype.com.sampleroompaging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import quintype.com.sampleroompaging.adapter.SampleAdapter
import quintype.com.sampleroompaging.viewmodel.SampleViewModel

open class MainActivity : AppCompatActivity() {

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
}
