package com.example.session_1.ui.settings_person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.session_1.R
import com.example.session_1.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings_person.*
import kotlinx.android.synthetic.main.fragment_settings_person.view.*

class SettingsPersonFragment : BaseFragment() {

    private lateinit var mainViewModel: SettingsPersonViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainViewModel = ViewModelProviders.of(this).get(SettingsPersonViewModel::class.java)
        return inflater.inflate(R.layout.fragment_settings_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_back_to_main_fragment.setOnClickListener {
            rootActivity.navController.navigateUp()
        }
    }

}