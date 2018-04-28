package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class az extends er {
    /* renamed from: a */
    final /* synthetic */ aq f9812a;
    /* renamed from: c */
    private final ct f9813c;

    private az(aq aqVar) {
        this.f9812a = aqVar;
        this.f9813c = new ct();
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9813c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f9812a.m13756d()) {
            this.f9813c.m1611b(view, motionEvent, z, new ba(this));
        } else {
            m1613b(false);
        }
    }
}
