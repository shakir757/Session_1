package com.example.session_1.ui.pays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PaysViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Pays Fragment"
    }
    val text: LiveData<String> = _text
}