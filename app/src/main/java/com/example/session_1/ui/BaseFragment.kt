package com.example.session_1.ui

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.session_1.NavigationViewActivity

open class BaseFragment : Fragment() {
    lateinit var rootActivity : NavigationViewActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        rootActivity = activity as NavigationViewActivity
    }


}