package com.example.session_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_courses.*
import org.json.JSONObject

class CoursesActivity : AppCompatActivity() {

    val viewAdapter = ValutesAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        recycler_view_courses.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }

        viewAdapter.submitList(parcingDataValues())
        viewAdapter.notifyDataSetChanged()
    }

    private fun parcingDataValues(): List<Valute> {
        val url = "https://www.cbr-xml-daily.ru/daily_json.js"
        val listValutes: List<String> = listOf(
            "AUD", "AZN", "GBP",
            "AMD", "BYN", "BGN", "BRL", "HUF", "HKD", "DKK", "USD",
            "EUR", "INR", "KZT", "CAD", "KGS", "CNY", "MDL", "NOK",
            "PLN", "RON", "XDR", "SGD", "TJS", "TRY", "TMT", "UZS",
            "UAH", "CZK", "SEK", "CHF", "ZAR", "KRW", "JPY"
        )
        val jsonValutesParcingList: MutableList<Valute> = arrayListOf()

        val requestQueue = Volley.newRequestQueue(this)
        val responseListener = Response.Listener<JSONObject> { response ->
            val jsonObjectValutes = response.getJSONObject("Valute")
            for (i in listValutes) {
                val valuteData = jsonObjectValutes.getJSONObject(i)
                jsonValutesParcingList.add(
                    Valute(
                        charCode = valuteData.getString("CharCode"),
                        name = valuteData.getString("Name"),
                        currencyValue = valuteData.getDouble("Value"),
                        currencyPrevisionValue = valuteData.getDouble("Previous")
                    )
                )
            }
        }
        val responseErrorListener = Response.ErrorListener {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }

        val request = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            responseListener,
            responseErrorListener
        )

        requestQueue.add(request)

        return jsonValutesParcingList
    }

    fun testData(): List<Valute>{
        return listOf(
            Valute(
                charCode = "usd",
                name = "valuteName",
                currencyValue = 26.555,
                currencyPrevisionValue = 24.8
            ),
            Valute(
                charCode = "eur",
                name = "valuteName",
                currencyValue = 28.555,
                currencyPrevisionValue = 2444.8
            ),
        )
    }
}