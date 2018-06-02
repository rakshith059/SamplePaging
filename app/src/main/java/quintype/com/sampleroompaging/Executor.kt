package quintype.com.sampleroompaging

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created SampleRoomPaging by rakshith on 6/1/18.
 */

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}