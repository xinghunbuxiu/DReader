package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class ax extends er {
    final /* synthetic */ aq a;
    private final dt c;

    private ax(aq aqVar) {
        this.a = aqVar;
        this.c = new dt();
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.a.d()) {
            b(false);
        } else if (motionEvent.getActionMasked() == 0) {
            this.a.e();
        } else if (motionEvent.getActionMasked() == 1) {
            this.a.f();
        } else {
            this.c.b(view, motionEvent, z, new ay(this));
        }
    }
}
