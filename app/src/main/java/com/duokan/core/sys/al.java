package com.duokan.core.sys;

import java.util.concurrent.FutureTask;

class al extends FutureTask {
    public final String a;
    private boolean b = false;

    public al(String str, Runnable runnable) {
        super(runnable, null);
        this.a = str;
    }

    public void run() {
        try {
            super.run();
        } finally {
            ah.a.submit(new am(this));
        }
    }
}
