package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class ax extends er {
    /* renamed from: a */
    final /* synthetic */ aq f9809a;
    /* renamed from: c */
    private final dt f9810c;

    private ax(aq aqVar) {
        this.f9809a = aqVar;
        this.f9810c = new dt();
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9810c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.f9809a.m13756d()) {
            m1613b(false);
        } else if (motionEvent.getActionMasked() == 0) {
            this.f9809a.m13757e();
        } else if (motionEvent.getActionMasked() == 1) {
            this.f9809a.m13758f();
        } else {
            this.f9810c.m1611b(view, motionEvent, z, new ay(this));
        }
    }
}
