package com.example.session_1.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.session_1.NavigationViewActivity
import com.example.session_1.R
import com.example.session_1.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : BaseFragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        root.button_person.setOnClickListener {
            rootActivity.navController.navigate(R.id.action_navigation_main_to_settings_person)
        }


        return root
    }

}