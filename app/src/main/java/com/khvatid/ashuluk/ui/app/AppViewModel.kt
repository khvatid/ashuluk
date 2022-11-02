package com.khvatid.ashuluk.ui.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khvatid.ashuluk.domain.usecase.GetLaunchEntityUseCase
import com.khvatid.ashuluk.domain.util.ParentDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(
    private val getLaunchEntityUseCase: GetLaunchEntityUseCase,
) :
    ViewModel() {

    private val _startDestination: MutableState<String> = mutableStateOf(ParentDestination.AUTH)
    val startDestination: State<String> get() = _startDestination

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        viewModelScope.launch {
            val model = getLaunchEntityUseCase.execute()
            _startDestination.value = model.startDestination
            _isLoading.postValue(false)
        }
    }

}
