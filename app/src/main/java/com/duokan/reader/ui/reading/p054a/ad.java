package com.duokan.reader.ui.reading.p054a;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0383g;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.reader.ui.reading.su;

/* renamed from: com.duokan.reader.ui.reading.a.ad */
public class ad extends er {
    /* renamed from: a */
    private final su f9185a;
    /* renamed from: c */
    private final RectF f9186c = new RectF();
    /* renamed from: d */
    private final C0383g f9187d = new C0383g();

    public ad(su suVar) {
        this.f9185a = suVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        C0383g c0383g = this.f9187d;
        boolean z2 = z || !this.f9187d.m1618c();
        c0383g.m1612b(view, z2);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = false;
        if (esVar instanceof af) {
            this.f9187d.m1611b(view, motionEvent, z, new ae(this, (af) esVar));
            if (m1618c() && this.f9187d.m1618c()) {
                z2 = true;
            }
            m1613b(z2);
            m1622e(this.f9185a.ak());
            return;
        }
        m1613b(false);
    }
}
