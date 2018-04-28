package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class aey extends er {
    /* renamed from: a */
    final /* synthetic */ adz f9608a;
    /* renamed from: c */
    private final ct f9609c;

    private aey(adz adz) {
        this.f9608a = adz;
        this.f9609c = new ct();
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9609c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f9608a.m13449e()) {
            this.f9609c.m1611b(view, motionEvent, z, new aez(this));
        } else {
            m1613b(false);
        }
    }
}
