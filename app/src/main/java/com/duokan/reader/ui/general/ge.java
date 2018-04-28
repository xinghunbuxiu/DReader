package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0383g;
import com.duokan.core.ui.cd;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

public class ge extends er {
    /* renamed from: a */
    final /* synthetic */ PagesView f7268a;
    /* renamed from: c */
    private final cd f7269c = new cd();
    /* renamed from: d */
    private final C0383g f7270d = new C0383g(2);
    /* renamed from: e */
    private PointF f7271e = null;

    protected ge(PagesView pagesView) {
        this.f7268a = pagesView;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        boolean z2 = false;
        cd cdVar = this.f7269c;
        boolean z3 = z || !this.f7269c.m1618c();
        cdVar.m1612b(view, z3);
        C0383g c0383g = this.f7270d;
        if (z || !this.f7270d.m1618c()) {
            z2 = true;
        }
        c0383g.m1612b(view, z2);
        this.f7269c.m1756a(0.01f);
        this.f7269c.m1757a(dv.getScaledPagingTouchSlop(view.getContext()));
        this.f7271e = null;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        this.f7269c.m1611b(view, motionEvent, z, new gf(this));
        this.f7270d.m1611b(view, motionEvent, z, new gg(this));
        if (this.f7271e != null && motionEvent.getActionMasked() == 1) {
            if (Float.compare(this.f7268a.getZoomFactor(), 1.0f) < 0) {
                this.f7268a.m10004b((int) this.f7271e.x, (int) this.f7271e.y, 1.0f);
            } else if (Float.compare(this.f7268a.getZoomFactor(), 3.0f) > 0) {
                this.f7268a.m10004b((int) this.f7271e.x, (int) this.f7271e.y, 3.0f);
            }
        }
        m1622e(this.f7270d.m1624f());
        if (!(this.f7269c.m1618c() || this.f7270d.m1618c())) {
            z2 = false;
        }
        m1613b(z2);
    }
}
