package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

class eu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ et f1229a;
    /* renamed from: b */
    private final View f1230b;
    /* renamed from: c */
    private MotionEvent f1231c;
    /* renamed from: d */
    private final boolean f1232d;

    public eu(et etVar, View view, MotionEvent motionEvent, boolean z) {
        this.f1229a = etVar;
        this.f1230b = view;
        this.f1232d = z;
        this.f1231c = MotionEvent.obtain(motionEvent);
    }

    public void run() {
        if (this.f1229a.f1228g == this) {
            this.f1229a.f1227f = false;
            this.f1229a.f1228g = null;
            this.f1229a.m2033a(this.f1230b, this.f1231c, true, this.f1232d);
        }
        if (this.f1231c != null) {
            this.f1231c.recycle();
            this.f1231c = null;
        }
    }
}
