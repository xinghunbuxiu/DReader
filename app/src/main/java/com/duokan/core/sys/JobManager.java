package com.duokan.core.sys;

import com.duokan.core.p029c.C0325a;
import java.util.PriorityQueue;

public class JobManager {
    /* renamed from: a */
    private final PriorityQueue<ae> priorityQueue = new PriorityQueue(1, new ab(this));

    /* renamed from: a */
    public void m847a(Runnable runnable) {
        m849a("", runnable);
    }

    /* renamed from: a */
    public void m849a(String str, Runnable runnable) {
        m848a(str, -1, runnable);
    }

    /* renamed from: a */
    public void m848a(String str, int i, Runnable runnable) {
        if (runnable != null) {
            m845a(new ae(this, str, i, runnable));
        }
    }

    /* renamed from: b */
    public void m850b(String str, Runnable runnable) {
        m848a(str, Integer.MAX_VALUE, runnable);
    }

    /* renamed from: c */
    public void m852c(String str, Runnable runnable) {
        m848a(str, -1, runnable);
    }

    /* renamed from: a */
    private void m845a(ae aeVar) {
        C0325a.m739b(this.priorityQueue, new ad(this, aeVar));
        this.priorityQueue.offer(aeVar);
    }

    /* renamed from: a */
    public void m846a() {
        while (!this.priorityQueue.isEmpty()) {
            ((ae) this.priorityQueue.peek()).f633c.run();
            this.priorityQueue.poll();
        }
    }

    /* renamed from: b */
    public boolean m851b(Runnable runnable) {
        return ((ae) C0325a.m738a(this.priorityQueue, new ac(this, runnable))) != null;
    }
}
