package com.duokan.core.sys;

import com.duokan.core.c.IRunTask;

class ac implements IRunTask {
    final /* synthetic */ Runnable a;
    final /* synthetic */ DelayedRunnableQueue b;

    ac(DelayedRunnableQueue aaVar, Runnable runnable) {
        this.b = aaVar;
        this.a = runnable;
    }

    public boolean a(RunTask aeVar) {
        return aeVar.c == this.a;
    }
}
