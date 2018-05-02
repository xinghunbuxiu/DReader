package com.duokan.reader.ui.reading.p054a;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0392q;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

/* renamed from: com.duokan.reader.ui.reading.a.ag */
public class ag extends er {
    /* renamed from: a */
    private final ak f9190a;
    /* renamed from: c */
    private final dt f9191c = new dt();
    /* renamed from: d */
    private final C0392q f9192d = new C0392q();
    /* renamed from: e */
    private final ct f9193e = new ct();
    /* renamed from: f */
    private boolean f9194f = false;

    public ag(ak akVar) {
        this.f9190a = akVar;
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    public void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (this.f9194f) {
            this.f9192d.m1611b(view, motionEvent, z, new ah(this));
            if (!m1623e()) {
                if (motionEvent.getActionMasked() == 1) {
                    ak akVar = this.f9190a;
                    if (this.f9190a.mo2447e()) {
                        z2 = false;
                    }
                    akVar.mo2446a(z2);
                    this.f9194f = false;
                    return;
                }
            }
            return;
        }
        this.f9191c.m1611b(view, motionEvent, z, new ai(this, motionEvent));
        if (this.f9190a.mo2447e()) {
            this.f9193e.m1611b(view, motionEvent, z, new aj(this));
        }
    }

    /* renamed from: a */
    public void mo511a(View view, boolean z) {
        boolean z2 = false;
        this.f9194f = false;
        dt dtVar = this.f9191c;
        if (z || !this.f9191c.m1618c()) {
            z2 = true;
        }
        dtVar.m1612b(view, z2);
        this.f9191c.m1882a(dv.getScaledPagingTouchSlop(view.getContext()));
        this.f9191c.m1881a(0.0f);
        this.f9191c.m1885b(-30.0f);
        this.f9191c.m1887c(30.0f);
        this.f9191c.m1886b(1);
        this.f9193e.m1612b(view, z);
        this.f9192d.m1612b(view, z);
    }
}
