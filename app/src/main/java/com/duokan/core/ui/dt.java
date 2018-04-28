package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.reader.ui.general.ix;

public class dt extends er {
    /* renamed from: a */
    private final ix f1185a;
    /* renamed from: c */
    private float f1186c;
    /* renamed from: d */
    private float f1187d;
    /* renamed from: e */
    private float f1188e;
    /* renamed from: f */
    private int f1189f;
    /* renamed from: g */
    private int f1190g;
    /* renamed from: h */
    private int f1191h;

    public dt() {
        this(1.0f);
    }

    public dt(float f) {
        this.f1185a = new ix();
        this.f1186c = 1.0f;
        this.f1187d = 0.0f;
        this.f1188e = 180.0f;
        this.f1189f = 0;
        this.f1190g = 0;
        this.f1191h = -1;
        this.f1186c = f;
    }

    /* renamed from: a */
    public void m1881a(float f) {
        this.f1186c = f;
    }

    /* renamed from: b */
    public void m1885b(float f) {
        this.f1187d = f;
    }

    /* renamed from: c */
    public void m1887c(float f) {
        this.f1188e = f;
    }

    /* renamed from: a */
    public void m1882a(int i) {
        this.f1189f = i;
    }

    /* renamed from: b */
    public void m1886b(int i) {
        this.f1190g = Math.max(0, i);
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        m1880a(null);
        this.f1191h = -1;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        ix ixVar = new ix(view, motionEvent);
        if (esVar instanceof du) {
            du duVar = (du) esVar;
            if (ixVar.m10827d() != 2) {
                m1880a(null);
                return;
            } else if (this.f1185a.m10823b()) {
                m1880a(ixVar);
                return;
            } else if (ixVar.m10828e() > 2 || ixVar.m10828e() != this.f1185a.m10828e()) {
                m1880a(ixVar);
                return;
            } else if (ixVar.m10828e() == 1) {
                r3 = this.f1185a.m10817a(0, new PointF());
                r5 = ixVar.m10817a(0, new PointF());
                r5.offset(-r3.x, -r3.y);
                if (this.f1191h >= 0) {
                    r4 = this.f1191h + 1;
                    this.f1191h = r4;
                    if (r4 > this.f1190g && Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.f1186c, 2.0d)) >= 0) {
                        ixVar.m10818a(r3);
                        ixVar.m10822b(r5);
                        duVar.mo527a(this, ixVar.m10825c(), r3, r5);
                        m1880a(ixVar);
                        return;
                    }
                    return;
                } else if (Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.f1189f, 2.0d)) >= 0) {
                    ixVar.m10818a(r3);
                    ixVar.m10822b(r5);
                    if (m1608a(new PointF(0.0f, 0.0f), r5, (double) this.f1187d, (double) this.f1188e)) {
                        this.f1191h++;
                    }
                    m1880a(ixVar);
                    return;
                } else {
                    return;
                }
            } else {
                int b = ixVar.m10821b(this.f1185a.m10816a(0));
                r4 = ixVar.m10821b(this.f1185a.m10816a(1));
                if (b < 0 || r4 < 0) {
                    m1613b(false);
                    return;
                }
                r5 = this.f1185a.m10817a(0, new PointF());
                PointF a = this.f1185a.m10817a(1, new PointF());
                r3 = ixVar.m10817a(b, new PointF());
                PointF a2 = ixVar.m10817a(r4, new PointF());
                double b2 = m1609b(r5, a);
                double b3 = m1609b(r3, a2);
                double d = m1619d(r5, a);
                double d2 = m1619d(r3, a2);
                if (Math.abs(b3 - b2) > 10.0d || Math.abs(d2 - d) > ((double) m1610b(ixVar.m10825c()))) {
                    m1880a(ixVar);
                    return;
                }
                PointF pointF = new PointF((r5.x + a.x) / 2.0f, (r5.y + a.y) / 2.0f);
                a = new PointF((r3.x + a2.x) / 2.0f, (r3.y + a2.y) / 2.0f);
                r5 = new PointF(a.x - pointF.x, a.y - pointF.y);
                if (this.f1191h >= 0) {
                    b = this.f1191h + 1;
                    this.f1191h = b;
                    if (b > this.f1190g && Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.f1186c, 2.0d)) >= 0) {
                        ixVar.m10818a(pointF);
                        ixVar.m10822b(r5);
                        duVar.mo527a(this, ixVar.m10825c(), pointF, r5);
                        m1880a(ixVar);
                        return;
                    }
                    return;
                } else if (Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.f1189f, 2.0d)) >= 0) {
                    ixVar.m10818a(pointF);
                    ixVar.m10822b(r5);
                    if (m1608a(new PointF(0.0f, 0.0f), r5, (double) this.f1187d, (double) this.f1188e)) {
                        this.f1191h++;
                    }
                    m1880a(ixVar);
                    return;
                } else {
                    return;
                }
            }
        }
        m1613b(false);
    }

    /* renamed from: a */
    private void m1880a(ix ixVar) {
        this.f1185a.m10820a(ixVar);
    }
}
