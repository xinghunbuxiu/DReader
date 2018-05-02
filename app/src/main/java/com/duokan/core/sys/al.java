package com.duokan.core.sys;

import java.util.concurrent.FutureTask;

class al<T> extends FutureTask<T> {
    /* renamed from: a */
    public final String f645a;
    /* renamed from: b */
    private boolean f646b = false;

    public al(String str, Runnable runnable) {
        super(runnable, null);
        this.f645a = str;
    }

    public void run() {
        try {
            super.run();
        } finally {
            ah.f637a.submit(new am(this));
        }
    }
}
