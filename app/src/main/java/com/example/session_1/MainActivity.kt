package com.example.session_1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.util.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card_location.setOnClickListener {
            val intent = Intent(this, AtmActivity::class.java)
            startActivity(intent)
        }

        card_courses.setOnClickListener {
            val intent = Intent(this, CoursesActivity::class.java)
            startActivity(intent)
        }

        button_enter.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.dialog?.window?.setBackgroundDrawableResource(R.drawable.background_alert_dialog)
            myDialogFragment.show(manager, "myDialog")
        }

        parsingVolutes()
        getDate()
    }

    private fun parsingVolutes(){
        val url = "https://www.cbr-xml-daily.ru/daily_json.js"
        val requestQueue = Volley.newRequestQueue(this)
        val responseListener = Response.Listener<JSONObject> { response ->
            val jsonArray = response.getJSONObject("Valute")

            val scale = 10.0.pow(2)
            text_view_usd_count.text = (Math.ceil(jsonArray.getJSONObject("USD")
                .getDouble("Value") * scale) / scale).toString()
            text_view_eur_count.text = (Math.ceil(jsonArray.getJSONObject("EUR")
                .getDouble("Value") * scale) / scale).toString()
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
    }

    private fun getDate(){
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)

        var textDate = ""

        if ((day < 10) and (month < 10)){
            textDate = "0" + day.toString() + ".0" + month.toString() + "." + year.toString()
        } else if (day < 10) {
            textDate = "0" + day.toString() + "." + month.toString() + "." + year.toString()
        } else if (month < 10){
            textDate = day.toString() + ".0" + month.toString() + "." + year.toString()
        } else {
            textDate = day.toString() + "." + month.toString() + "." + year.toString()
        }

        text_view_date.text = textDate
    }
}