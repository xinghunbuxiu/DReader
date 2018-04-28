package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.reader.ui.general.ix;

public class cd extends er {
    /* renamed from: a */
    private final ix f1066a = new ix();
    /* renamed from: c */
    private float f1067c = 0.0f;
    /* renamed from: d */
    private int f1068d = 0;
    /* renamed from: e */
    private boolean f1069e = false;

    /* renamed from: a */
    public void m1756a(float f) {
        this.f1067c = f;
    }

    /* renamed from: a */
    public void m1757a(int i) {
        this.f1068d = i;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        m1755a(null);
        this.f1069e = false;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        ix ixVar = new ix(view, motionEvent);
        if (esVar instanceof ce) {
            ce ceVar = (ce) esVar;
            if (ixVar.m10827d() != 2) {
                m1755a(null);
                return;
            } else if (ixVar.m10828e() != 2) {
                m1755a(null);
                return;
            } else if (this.f1066a.m10823b()) {
                m1755a(ixVar);
                return;
            } else {
                double d = m1619d(this.f1066a.m10817a(0, new PointF()), this.f1066a.m10817a(1, new PointF()));
                double d2 = m1619d(ixVar.m10817a(0, new PointF()), ixVar.m10817a(1, new PointF()));
                if (this.f1069e) {
                    float f = (float) (d2 / d);
                    PointF pointF = new PointF((ixVar.m10824c(0) + ixVar.m10824c(1)) / 2.0f, (ixVar.m10826d(0) + ixVar.m10826d(1)) / 2.0f);
                    ixVar.m10818a(pointF);
                    if (Float.compare(Math.abs(f - 1.0f), this.f1067c) >= 0) {
                        ceVar.mo537a(this, view, pointF, f);
                        m1755a(ixVar);
                        return;
                    }
                    return;
                } else if (Math.abs(d2 - d) > ((double) this.f1068d)) {
                    m1755a(ixVar);
                    this.f1069e = true;
                    return;
                } else {
                    return;
                }
            }
        }
        m1613b(false);
    }

    /* renamed from: a */
    private void m1755a(ix ixVar) {
        this.f1066a.m10820a(ixVar);
    }
}
