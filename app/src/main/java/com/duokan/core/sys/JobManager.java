package com.duokan.core.sys;

import com.duokan.core.p029c.RunTaskManage;
import java.util.PriorityQueue;

public class JobManager {
    
    private final PriorityQueue<ae> priorityQueue = new PriorityQueue(1, new ab(this));

    
    public void m847a(Runnable runnable) {
        m849a("", runnable);
    }

    
    public void m849a(String str, Runnable runnable) {
        m848a(str, -1, runnable);
    }

    
    public void m848a(String str, int i, Runnable runnable) {
        if (runnable != null) {
            m845a(new ae(this, str, i, runnable));
        }
    }

    
    public void m850b(String str, Runnable runnable) {
        m848a(str, Integer.MAX_VALUE, runnable);
    }

    
    public void m852c(String str, Runnable runnable) {
        m848a(str, -1, runnable);
    }

    
    private void m845a(ae aeVar) {
        RunTaskManage.removeRunTask(this.priorityQueue, new ad(this, aeVar));
        this.priorityQueue.offer(aeVar);
    }

    
    public void m846a() {
        while (!this.priorityQueue.isEmpty()) {
            ((ae) this.priorityQueue.peek()).f633c.run();
            this.priorityQueue.poll();
        }
    }

    
    public boolean m851b(Runnable runnable) {
        return ((ae) RunTaskManage.m738a(this.priorityQueue, new ac(this, runnable))) != null;
    }
}
