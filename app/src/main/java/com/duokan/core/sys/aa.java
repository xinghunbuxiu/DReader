package com.duokan.core.sys;

import com.duokan.core.c.a;

import java.util.PriorityQueue;

public class aa {
    private final PriorityQueue a = new PriorityQueue(1, new ab(this));

    public void a(Runnable runnable) {
        a("", runnable);
    }

    public void a(String str, Runnable runnable) {
        a(str, -1, runnable);
    }

    public void a(String str, int i, Runnable runnable) {
        if (runnable != null) {
            a(new ae(this, str, i, runnable));
        }
    }

    public void b(String str, Runnable runnable) {
        a(str, Integer.MAX_VALUE, runnable);
    }

    public void c(String str, Runnable runnable) {
        a(str, -1, runnable);
    }

    private void a(ae aeVar) {
        a.b(this.a, new ad(this, aeVar));
        this.a.offer(aeVar);
    }

    public void a() {
        while (!this.a.isEmpty()) {
            ((ae) this.a.peek()).c.run();
            this.a.poll();
        }
    }

    public boolean b(Runnable runnable) {
        return ((ae) a.a(this.a, new ac(this, runnable))) != null;
    }
}
