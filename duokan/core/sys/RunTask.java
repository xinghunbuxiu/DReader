package com.duokan.core.sys;

class RunTask {
    public final String name;
    public final int id;
    public final Runnable runnable;
    final  DelayedRunnableQueue runnableQueue;

    public RunTask(DelayedRunnableQueue runnableQueue, String name, int id, Runnable runnable) {
        this.runnableQueue = runnableQueue;
        this.name = name;
        this.id = id;
        this.runnable = runnable;
    }
}
