package com.duokan.reader.ui.reading;

import android.view.MotionEvent;

import com.duokan.reader.ui.general.cy;

class jt extends cy {
    final /* synthetic */ jr b;

    private jt(jr jrVar) {
        this.b = jrVar;
        super(jrVar);
    }

    protected int ab() {
        return this.b.a.b ? super.ab() + 1 : super.ab();
    }

    protected void a(int i, int i2) {
        super.a(i, i2);
    }

    public boolean c(MotionEvent motionEvent) {
        if (this.b.a.k()) {
            return false;
        }
        return super.c(motionEvent);
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.b.a.k()) {
            return false;
        }
        return super.b(motionEvent);
    }
}
