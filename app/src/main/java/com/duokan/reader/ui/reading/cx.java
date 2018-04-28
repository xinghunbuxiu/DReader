package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.C0383g;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

public class cx extends er {
    /* renamed from: a */
    final /* synthetic */ cq f9967a;
    /* renamed from: c */
    private final C0383g f9968c = new C0383g(2);
    /* renamed from: d */
    private Pair<gx, Integer> f9969d = null;

    public cx(cq cqVar) {
        this.f9967a = cqVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        C0383g c0383g = this.f9968c;
        boolean z2 = z || !this.f9968c.m1618c();
        c0383g.m1612b(view, z2);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.f9967a.f9949a.mo2181w().mo2295f() && m1618c() && !m1623e() && this.f9968c.m1618c()) {
            if (motionEvent.getAction() == 0) {
                this.f9969d = this.f9967a.f9949a.mo2125c(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
            if (this.f9969d != null) {
                m1622e(true);
                this.f9968c.m1611b(view, motionEvent, z, new cy(this));
                return;
            }
            m1613b(false);
        }
    }
}
