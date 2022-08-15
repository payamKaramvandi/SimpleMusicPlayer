package de.skoove.webmock

import android.content.Context
import android.net.Uri
import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import de.skoove.webmock.AssetReaderUtil.asset

const val MANIFEST = "/Learnfield-GmbH/CodingChallenge/tree/master/shared/simple%20audio%20player"
const val MANIFEST_SUCCESS = "manifest.json"


class SuccessDispatcher(
    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
) : Dispatcher() {
    private val responseFilesByPath: Map<String, String> = mapOf(
        MANIFEST to MANIFEST_SUCCESS
    )

    override fun dispatch(request: RecordedRequest): MockResponse {
        val errorResponse = MockResponse().setResponseCode(404)

        val pathWithoutQueryParams = Uri.parse(request.path).path ?: return errorResponse
        val responseFile = responseFilesByPath[pathWithoutQueryParams]

        return if (responseFile != null) {
            val responseBody = asset(context, responseFile)
            MockResponse().setResponseCode(200).setBody(responseBody)
        } else {
            throw Throwable("Uri.parse(request.path).path null")
            errorResponse
        }
    }
}
