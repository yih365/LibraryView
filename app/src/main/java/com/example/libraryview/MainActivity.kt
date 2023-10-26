package com.example.libraryview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    var subject = "fantasy"
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBooksBySubject(subject)
    }

    private fun getBooksBySubject(subject: String) {
        val URL = "http://openlibrary.org/subjects/$subject.json"
        val client = AsyncHttpClient()

        client.get(URL, object: JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, statusCode.toString())
                if (response != null) {
                    Log.e(TAG, "failed to get caption $response")
                }
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                val worksJsonArray = json?.jsonObject?.getJSONArray("works")
                Log.d(TAG, worksJsonArray.toString())
                val bookList = mutableListOf<BookDetail>()
                if (worksJsonArray != null) {
                    for (i in 0 until worksJsonArray.length()) {
                        val work = worksJsonArray.getJSONObject(i)
                        val title = work.getString("title")
                        val coverId = work.getString("cover_id")
                        val bookDetail = BookDetail(title, "https://covers.openlibrary.org/b/id/$coverId.jpg")
                        bookList.add(bookDetail)
                    }
                }
            }
        })
    }
}