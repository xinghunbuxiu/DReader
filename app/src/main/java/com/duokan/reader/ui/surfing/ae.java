package com.duokan.reader.ui.surfing;

import android.widget.FrameLayout;

import com.duokan.core.sys.TaskHandler;

class ae implements Runnable {
    final /* synthetic */ FrameLayout a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ f c;

    ae(f fVar, FrameLayout frameLayout, Runnable runnable) {
        this.c = fVar;
        this.a = frameLayout;
        this.b = runnable;
    }

    public void run() {
        this.c.h.removeView(this.a);
        this.a.removeAllViews();
        TaskHandler.postTask(this.b);
    }
}
