package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.cd;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

/* renamed from: com.duokan.reader.ui.reading.a.w */
public class C1442w extends er {
    /* renamed from: a */
    private ct f9247a = new ct();
    /* renamed from: c */
    private cd f9248c = new cd();
    /* renamed from: d */
    private C1445z f9249d;

    public C1442w(C1445z c1445z) {
        this.f9249d = c1445z;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9247a.m1612b(view, z);
        this.f9248c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        this.f9247a.m1611b(view, motionEvent, z, new C1443x(this));
        this.f9248c.m1611b(view, motionEvent, z, new C1444y(this));
    }
}
