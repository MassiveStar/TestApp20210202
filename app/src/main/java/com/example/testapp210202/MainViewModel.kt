package com.example.testapp210202

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _dato1 = MutableLiveData<Double>()
    private val _dato2 = MutableLiveData<Double>()
    private val _resultado = MutableLiveData<Double>()

    init {
        _dato1.value = 0.0
        _dato2.value = 0.0
        _resultado.value = 0.0
    }

    val dato1: LiveData<Double>
        get() = _dato1
    val dato2: LiveData<Double>
        get() = _dato2
    val resultado: LiveData<Double>
        get() = _resultado

    override fun onCleared() {
        super.onCleared()
        // Dispose All your Subscriptions to avoid memory leaks
    }
}