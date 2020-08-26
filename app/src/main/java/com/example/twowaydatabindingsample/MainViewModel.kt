package com.example.twowaydatabindingsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val text = MutableLiveData<String>()
}