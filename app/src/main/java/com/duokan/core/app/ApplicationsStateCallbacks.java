package com.duokan.core.app;

import com.duokan.core.app.ManagedApp.RunningState;


public interface ApplicationsStateCallbacks {
    void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2);
}
