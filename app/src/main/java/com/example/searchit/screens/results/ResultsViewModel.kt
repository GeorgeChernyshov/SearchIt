package com.example.searchit.screens.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchit.network.ResultPage
import com.example.searchit.network.SearchItApi
import com.example.searchit.network.SearchResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsViewModel(val query: String) : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _items = MutableLiveData<List<SearchResult>>()
    val items: LiveData<List<SearchResult>>
        get() = _items

    val tmp = MutableLiveData<Boolean>()

    fun getSearchResults() {
        coroutineScope.launch {
            var getPropertiesDeferred = SearchItApi.retrofitService.getProperties(query)
            try {
                var resultPage = getPropertiesDeferred.await()
                _items.value = resultPage.items
                tmp.value = true
            } catch (e: Exception) {
                _status.value = "Failure: " + e.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}