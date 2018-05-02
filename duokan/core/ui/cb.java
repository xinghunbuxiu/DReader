package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.reader.ui.general.jn;

public class cb extends er {
    private final jn a = new jn();
    private float c = 0.0f;

    protected void a(View view, boolean z) {
        a(null);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        jn jnVar = new jn(view, motionEvent);
        if (esVar instanceof cc) {
            cc ccVar = (cc) esVar;
            if (jnVar.d() != 2) {
                a(null);
                return;
            } else if (jnVar.e() != 2) {
                a(null);
                return;
            } else if (this.a.b()) {
                a(jnVar);
                return;
            } else {
                int b = jnVar.b(this.a.a(0));
                int b2 = jnVar.b(this.a.a(1));
                if (b < 0 || b2 < 0) {
                    b(false);
                    return;
                }
                PointF a = this.a.a(0, new PointF());
                PointF a2 = this.a.a(1, new PointF());
                PointF a3 = jnVar.a(b, new PointF());
                PointF a4 = jnVar.a(b2, new PointF());
                double b3 = b(a, a2);
                double b4 = b(a3, a4);
                PointF pointF = new PointF((a3.x + a4.x) / 2.0f, (a3.y + a4.y) / 2.0f);
                jnVar.a(pointF);
                float a5 = (float) a(b4 - b3, -180.0d, 180.0d);
                if (Float.compare(Math.abs(a5), this.c) >= 0) {
                    ccVar.a(view, pointF, a5);
                    a(jnVar);
                    return;
                }
                return;
            }
        }
        b(false);
    }

    private void a(jn jnVar) {
        this.a.a(jnVar);
    }
}
