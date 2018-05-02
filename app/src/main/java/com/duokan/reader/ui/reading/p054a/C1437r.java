package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.bu;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.r */
public class C1437r extends er {
    /* renamed from: a */
    private final su f9233a;
    /* renamed from: c */
    private final bu f9234c = new bu();

    public C1437r(su suVar) {
        this.f9233a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9234c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof C1439t) {
            C1439t c1439t = (C1439t) esVar;
            if (this.f9233a.mo2007X().mo2329e()) {
                this.f9234c.m1611b(view, motionEvent, z, new C1438s(this, c1439t));
                return;
            }
            return;
        }
        m1613b(false);
    }
}
