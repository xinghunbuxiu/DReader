package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0392q;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

/* renamed from: com.duokan.reader.ui.reading.a.c */
public class C1422c extends er {
    /* renamed from: a */
    private final C1425f f9211a;
    /* renamed from: c */
    private final dt f9212c = new dt();
    /* renamed from: d */
    private final C0392q f9213d = new C0392q();
    /* renamed from: e */
    private boolean f9214e = false;

    public C1422c(C1425f c1425f) {
        this.f9211a = c1425f;
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (motionEvent.getX() < ((float) dv.m1932b(view.getContext(), 23.0f))) {
            m1617c(true);
        } else if (!(this.f9211a.mo2400a() || this.f9214e)) {
            m1613b(false);
        }
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    public void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        this.f9213d.m1611b(view, motionEvent, z, new C1423d(this));
        if (this.f9214e) {
            if (!m1623e()) {
                if (motionEvent.getActionMasked() == 1) {
                    C1425f c1425f = this.f9211a;
                    if (this.f9211a.mo2400a()) {
                        z2 = false;
                    }
                    c1425f.mo2399a(z2);
                    this.f9214e = false;
                    return;
                }
            }
            return;
        }
        this.f9212c.m1611b(view, motionEvent, z, new C1424e(this));
    }

    /* renamed from: a */
    public void mo511a(View view, boolean z) {
        boolean z2 = false;
        this.f9214e = false;
        dt dtVar = this.f9212c;
        if (z || !this.f9212c.m1618c()) {
            z2 = true;
        }
        dtVar.m1612b(view, z2);
        this.f9212c.m1882a(dv.getScaledPagingTouchSlop(view.getContext()));
        this.f9212c.m1881a(0.0f);
        this.f9212c.m1885b(-30.0f);
        this.f9212c.m1887c(30.0f);
        this.f9212c.m1886b(1);
        this.f9213d.m1612b(view, z);
    }
}
