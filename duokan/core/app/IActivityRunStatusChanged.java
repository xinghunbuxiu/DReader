package com.duokan.core.app;

import com.duokan.core.app.ManagedApp.RunningState;

public interface IActivityRunStatusChanged {
    void onRunningStateChanged(ManagedApp managedApp, RunningState newRunningState, RunningState oldRunningState);
}
