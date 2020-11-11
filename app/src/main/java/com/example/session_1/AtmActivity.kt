package com.example.session_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_atm.*
import kotlinx.android.synthetic.main.activity_courses.*

class AtmActivity : AppCompatActivity() {

    val viewAdapter = BanksAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atm)

        recycler_view_atm.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }

        viewAdapter.submitList(testData())
        viewAdapter.notifyDataSetChanged()
    }

    fun testData(): List<Bank> {
        return listOf(
            Bank(
                "asdasd",
                "asdaf",
                true,
                "sdf2342342"
            ),
            Bank(
                "asdasd",
                "asdaf",
                false,
                "sdf2342342"
            )
        )
    }
}