package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.l */
public class C1431l extends er {
    /* renamed from: a */
    private final su f9225a;
    /* renamed from: c */
    private final ct f9226c = new ct();

    public C1431l(su suVar) {
        this.f9225a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9226c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof C1433n) {
            this.f9226c.m1611b(view, motionEvent, z, new C1432m(this, (C1433n) esVar));
            return;
        }
        m1613b(false);
    }
}
