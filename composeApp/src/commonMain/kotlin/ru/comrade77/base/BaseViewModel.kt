package ru.comrade77.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

public abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) : ViewModel() {
    private val _viewState = MutableStateFlow(initialState)
    private val _viewAction = MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    public fun viewStates(): StateFlow<State> = _viewState.asStateFlow()
    public fun viewActions(): SharedFlow<Action?> = _viewAction.asSharedFlow()

    protected var viewState: State
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }
    protected var viewAction: Action?
        get() = _viewAction.replayCache.last()
        set(value) {
            _viewAction.tryEmit(value)
        }
    
    public abstract fun obtainEvent(viewEvent: Event)
    public fun clearAction() {
        viewAction = null
    }
}