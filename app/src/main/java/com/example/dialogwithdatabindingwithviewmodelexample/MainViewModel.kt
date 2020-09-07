package com.example.dialogwithdatabindingwithviewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val text = MutableLiveData<String>()
}