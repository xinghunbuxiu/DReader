package com.duokan.core.sys;

import java.util.Comparator;

class QueueTaskComparator implements Comparator {
    final  DelayedRunnableQueue runnableQueue;

    QueueTaskComparator(DelayedRunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    public int compare(Object obj, Object obj2) {
        return a((RunTask) obj, (RunTask) obj2);
    }

    public int a(RunTask runTask, RunTask runTask2) {
        if (runTask.id < runTask2.id) {
            return 1;
        }
        if (runTask.id > runTask2.id) {
            return -1;
        }
        return 0;
    }
}
