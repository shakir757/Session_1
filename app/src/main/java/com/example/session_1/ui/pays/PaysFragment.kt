package com.example.session_1.ui.pays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.session_1.R

class PaysFragment : Fragment() {

  private lateinit var paysViewModel: PaysViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    paysViewModel =
    ViewModelProviders.of(this).get(PaysViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_pays, container, false)
    val textView: TextView = root.findViewById(R.id.text_pays)
    paysViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}