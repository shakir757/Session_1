package com.example.session_1.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.session_1.R
import com.example.session_1.ui.history.HistoryViewModel

class DialogsFragment: Fragment() {

    private lateinit var dialogsViewModel: DialogsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialogsViewModel = ViewModelProviders.of(this).get(DialogsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dialogs, container, false)
        val textView: TextView = root.findViewById(R.id.text_dialogs)
        dialogsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}