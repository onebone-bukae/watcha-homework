package me.onebone.watchahomework.ui.tracks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import me.onebone.watchahomework.shared.usecase.GetTrackUseCase
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel @Inject constructor(
	private val getTrackUseCase: GetTrackUseCase
): ViewModel() {
	val tracks = flow {
		val entries = getTrackUseCase.invoke()
		emit(entries)
	}.shareIn(viewModelScope, started = SharingStarted.WhileSubscribed(), replay = 1)
}
