package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0383g;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class gk extends er {
    /* renamed from: a */
    final /* synthetic */ gd f10243a;
    /* renamed from: c */
    private int f10244c = 0;
    /* renamed from: d */
    private boolean f10245d = false;
    /* renamed from: e */
    private final C0383g f10246e = new C0383g();
    /* renamed from: f */
    private final dt f10247f = new dt();

    public gk(gd gdVar) {
        this.f10243a = gdVar;
        this.f10247f.m1885b(60.0f);
        this.f10247f.m1887c(120.0f);
        this.f10247f.m1882a(30);
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        boolean z2 = false;
        this.f10244c = 0;
        this.f10245d = false;
        this.f10243a.setPullingDown(false);
        this.f10247f.m1612b(view, z);
        C0383g c0383g = this.f10246e;
        if (z || !this.f10246e.m1618c()) {
            z2 = true;
        }
        c0383g.m1612b(view, z2);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (this.f10245d && motionEvent.getAction() == 1) {
            if (!this.f10243a.f10226f) {
                this.f10243a.mo2443j();
            } else if (this.f10243a.f10224d != null) {
                this.f10243a.f10224d.run();
            }
        }
        this.f10246e.m1611b(view, motionEvent, z, new gl(this));
        this.f10247f.m1611b(view, motionEvent, z, new gm(this));
        if (!(m1618c() && (this.f10246e.m1618c() || this.f10247f.m1618c()))) {
            z2 = false;
        }
        m1613b(z2);
    }
}
