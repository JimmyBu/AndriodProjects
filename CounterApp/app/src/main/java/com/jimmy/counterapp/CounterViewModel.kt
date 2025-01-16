package com.jimmy.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    private val _repository : CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)

    // Expose the count as an immutable state
    val count: MutableState<Int> = _count

    fun increase(){
        // make sure the _count not exposed
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrease(){
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}