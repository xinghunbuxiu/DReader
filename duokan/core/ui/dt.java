package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.reader.ui.general.jn;

public class dt extends er {
    private final jn a;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;

    public dt() {
        this(1.0f);
    }

    public dt(float f) {
        this.a = new jn();
        this.c = 1.0f;
        this.d = 0.0f;
        this.e = 180.0f;
        this.f = 0;
        this.g = 0;
        this.h = -1;
        this.c = f;
    }

    public void a(float f) {
        this.c = f;
    }

    public void b(float f) {
        this.d = f;
    }

    public void c(float f) {
        this.e = f;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.g = Math.max(0, i);
    }

    protected void a(View view, boolean z) {
        a(null);
        this.h = -1;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        jn jnVar = new jn(view, motionEvent);
        if (esVar instanceof du) {
            du duVar = (du) esVar;
            if (jnVar.d() != 2) {
                a(null);
                return;
            } else if (this.a.b()) {
                a(jnVar);
                return;
            } else if (jnVar.e() > 2 || jnVar.e() != this.a.e()) {
                a(jnVar);
                return;
            } else if (jnVar.e() == 1) {
                r3 = this.a.a(0, new PointF());
                r5 = jnVar.a(0, new PointF());
                r5.offset(-r3.x, -r3.y);
                if (this.h >= 0) {
                    r4 = this.h + 1;
                    this.h = r4;
                    if (r4 > this.g && Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.c, 2.0d)) >= 0) {
                        jnVar.a(r3);
                        jnVar.b(r5);
                        duVar.a(this, jnVar.c(), r3, r5);
                        a(jnVar);
                        return;
                    }
                    return;
                } else if (Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.f, 2.0d)) >= 0) {
                    jnVar.a(r3);
                    jnVar.b(r5);
                    if (a(new PointF(0.0f, 0.0f), r5, (double) this.d, (double) this.e)) {
                        this.h++;
                    }
                    a(jnVar);
                    return;
                } else {
                    return;
                }
            } else {
                int b = jnVar.b(this.a.a(0));
                r4 = jnVar.b(this.a.a(1));
                if (b < 0 || r4 < 0) {
                    b(false);
                    return;
                }
                r5 = this.a.a(0, new PointF());
                PointF a = this.a.a(1, new PointF());
                r3 = jnVar.a(b, new PointF());
                PointF a2 = jnVar.a(r4, new PointF());
                double b2 = b(r5, a);
                double b3 = b(r3, a2);
                double d = d(r5, a);
                double d2 = d(r3, a2);
                if (Math.abs(b3 - b2) > 10.0d || Math.abs(d2 - d) > ((double) b(jnVar.c()))) {
                    a(jnVar);
                    return;
                }
                PointF pointF = new PointF((r5.x + a.x) / 2.0f, (r5.y + a.y) / 2.0f);
                a = new PointF((r3.x + a2.x) / 2.0f, (r3.y + a2.y) / 2.0f);
                r5 = new PointF(a.x - pointF.x, a.y - pointF.y);
                if (this.h >= 0) {
                    b = this.h + 1;
                    this.h = b;
                    if (b > this.g && Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.c, 2.0d)) >= 0) {
                        jnVar.a(pointF);
                        jnVar.b(r5);
                        duVar.a(this, jnVar.c(), pointF, r5);
                        a(jnVar);
                        return;
                    }
                    return;
                } else if (Double.compare(Math.pow((double) r5.x, 2.0d) + Math.pow((double) r5.y, 2.0d), Math.pow((double) this.f, 2.0d)) >= 0) {
                    jnVar.a(pointF);
                    jnVar.b(r5);
                    if (a(new PointF(0.0f, 0.0f), r5, (double) this.d, (double) this.e)) {
                        this.h++;
                    }
                    a(jnVar);
                    return;
                } else {
                    return;
                }
            }
        }
        b(false);
    }

    private void a(jn jnVar) {
        this.a.a(jnVar);
    }
}
