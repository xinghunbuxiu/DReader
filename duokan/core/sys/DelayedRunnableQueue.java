package com.duokan.core.sys;

import com.duokan.core.c.RunTaskManage;

import java.util.PriorityQueue;

public class DelayedRunnableQueue {
    private final PriorityQueue<RunTask> queue = new PriorityQueue(1, new QueueTaskComparator(this));

    public void offer(Runnable runnable) {
        offer("", runnable);
    }

    public void offer(String name, Runnable runnable) {
        offer(name, -1, runnable);
    }

    public void offer(String name, int task_id, Runnable runnable) {
        if (runnable != null) {
            offer(new RunTask(this, name, task_id, runnable));
        }
    }

    public void offerMax(String name, Runnable runnable) {
        offer(name, Integer.MAX_VALUE, runnable);
    }

    public void c(String name, Runnable runnable) {
        offer(name, -1, runnable);
    }

    private void offer(RunTask task) {
        RunTaskManage.removeRunTask(this.queue, new MyTask(this, task));
        this.queue.offer(task);
    }

    public void poll() {
        while (!this.queue.isEmpty()) {
            this.queue.peek().runnable.run();
            this.queue.poll();
        }
    }

    public boolean offerMax(Runnable runnable) {
        return RunTaskManage.findRunTask(this.queue, new ac(this, runnable)) != null;
    }
}
