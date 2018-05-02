package com.duokan.core.sys;

import android.text.TextUtils;

import com.duokan.core.c.IRunTask;

class MyTask implements IRunTask<RunTask> {
    final DelayedRunnableQueue runnableQueue;
    private final RunTask runTask;

    public MyTask(DelayedRunnableQueue runnableQueue, RunTask runTask) {
        this.runTask = runTask;
        this.runnableQueue = runnableQueue;
    }
    @Override
    public boolean isRunTask(RunTask runTask) {
        if (this.runTask.runnable == runTask.runnable) {
            return true;
        }
        if (TextUtils.isEmpty(this.runTask.name) || TextUtils.isEmpty(runTask.name)) {
            return false;
        }
        return this.runTask.name.equals(runTask.name);
}

}
