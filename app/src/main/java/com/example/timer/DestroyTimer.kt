package com.example.timer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class DestroyTimer(lifecycle: Lifecycle) : MainTimer(lifecycle) {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun startTimer(){
        runnable = Runnable {
            secondsCount++
            // postDelayed re-adds the action to the queue of actions the Handler is cycling
            // through. The delayMillis param tells the handler to run the runnable in
            // 1 second (1000ms)
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun stopTimer() {
        handler.removeCallbacks(runnable)
    }
}