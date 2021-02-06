package com.example.testapp210202

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    override fun onCleared() {
        super.onCleared()
        // Dispose All your Subscriptions to avoid memory leaks
    }
}