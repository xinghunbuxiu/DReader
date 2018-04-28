package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.reader.ui.general.ix;

public class cb extends er {
    /* renamed from: a */
    private final ix f1064a = new ix();
    /* renamed from: c */
    private float f1065c = 0.0f;

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        m1751a(null);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        ix ixVar = new ix(view, motionEvent);
        if (esVar instanceof cc) {
            cc ccVar = (cc) esVar;
            if (ixVar.m10827d() != 2) {
                m1751a(null);
                return;
            } else if (ixVar.m10828e() != 2) {
                m1751a(null);
                return;
            } else if (this.f1064a.m10823b()) {
                m1751a(ixVar);
                return;
            } else {
                int b = ixVar.m10821b(this.f1064a.m10816a(0));
                int b2 = ixVar.m10821b(this.f1064a.m10816a(1));
                if (b < 0 || b2 < 0) {
                    m1613b(false);
                    return;
                }
                PointF a = this.f1064a.m10817a(0, new PointF());
                PointF a2 = this.f1064a.m10817a(1, new PointF());
                PointF a3 = ixVar.m10817a(b, new PointF());
                PointF a4 = ixVar.m10817a(b2, new PointF());
                double b3 = m1609b(a, a2);
                double b4 = m1609b(a3, a4);
                PointF pointF = new PointF((a3.x + a4.x) / 2.0f, (a3.y + a4.y) / 2.0f);
                ixVar.m10818a(pointF);
                float a5 = (float) m1600a(b4 - b3, -180.0d, 180.0d);
                if (Float.compare(Math.abs(a5), this.f1065c) >= 0) {
                    ccVar.mo538a(view, pointF, a5);
                    m1751a(ixVar);
                    return;
                }
                return;
            }
        }
        m1613b(false);
    }

    /* renamed from: a */
    private void m1751a(ix ixVar) {
        this.f1064a.m10820a(ixVar);
    }
}
