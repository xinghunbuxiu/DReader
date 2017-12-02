package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

class eu implements Runnable {
    final /* synthetic */ et a;
    private final View b;
    private MotionEvent c;
    private final boolean d;

    public eu(et etVar, View view, MotionEvent motionEvent, boolean z) {
        this.a = etVar;
        this.b = view;
        this.d = z;
        this.c = MotionEvent.obtain(motionEvent);
    }

    public void run() {
        if (this.a.g == this) {
            this.a.f = false;
            this.a.g = null;
            this.a.a(this.b, this.c, true, this.d);
        }
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
    }
}
