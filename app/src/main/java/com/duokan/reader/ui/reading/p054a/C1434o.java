package com.duokan.reader.ui.reading.p054a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.o */
public class C1434o extends er {
    /* renamed from: a */
    private final su f9229a;
    /* renamed from: c */
    private final ct f9230c = new ct();

    public C1434o(su suVar) {
        this.f9229a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f9230c.m1612b(view, z);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (esVar instanceof C1436q) {
            C1436q c1436q = (C1436q) esVar;
            if (this.f9229a.mo2007X().mo2329e()) {
                this.f9230c.m1611b(view, motionEvent, z, new C1435p(this, c1436q));
                return;
            }
            return;
        }
        m1613b(false);
    }

    /* renamed from: a */
    private ae m12712a(Point point) {
        as aa = this.f9229a.aa();
        if (aa == null) {
            return null;
        }
        ae a = aa.mo1292a(point);
        if (a == null) {
            a = aa.mo1292a(new Point(point.x, point.y - (aa.mo1340p().f4335f / 2)));
        }
        if (a == null) {
            return aa.mo1292a(new Point(point.x, point.y + (aa.mo1340p().f4335f / 2)));
        }
        return a;
    }
}
