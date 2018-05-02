package com.duokan.reader.ui.reading.p054a;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0383g;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.j */
public class C1429j extends er {
    /* renamed from: a */
    private final su f9221a;
    /* renamed from: c */
    private final RectF f9222c = new RectF();
    /* renamed from: d */
    private final C0383g f9223d = new C0383g();

    public C1429j(su suVar) {
        this.f9221a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        C0383g c0383g = this.f9223d;
        boolean z2 = z || !this.f9223d.m1618c();
        c0383g.m1612b(view, z2);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        this.f9223d.m1611b(view, motionEvent, z, new C1430k(this));
    }
}
