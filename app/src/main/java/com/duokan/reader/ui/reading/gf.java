package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.core.ui.g;

class gf extends er {
    final /* synthetic */ fy a;
    private int c = 0;
    private boolean d = false;
    private final g e = new g();
    private final dt f = new dt();

    public gf(fy fyVar) {
        this.a = fyVar;
        this.f.b(60.0f);
        this.f.c(120.0f);
        this.f.a(30);
    }

    protected void a(View view, boolean z) {
        boolean z2 = false;
        this.c = 0;
        this.d = false;
        this.a.setPullingDown(false);
        this.f.b(view, z);
        g gVar = this.e;
        if (z || !this.e.c()) {
            z2 = true;
        }
        gVar.b(view, z2);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        boolean z2 = true;
        if (this.d && motionEvent.getAction() == 1) {
            if (!this.a.f) {
                this.a.j();
            } else if (this.a.d != null) {
                this.a.d.run();
            }
        }
        this.e.b(view, motionEvent, z, new gg(this));
        this.f.b(view, motionEvent, z, new gh(this));
        if (!(c() && (this.e.c() || this.f.c()))) {
            z2 = false;
        }
        b(z2);
    }
}
