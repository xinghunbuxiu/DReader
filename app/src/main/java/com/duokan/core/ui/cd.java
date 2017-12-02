package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.reader.ui.general.jn;

public class cd extends er {
    private final jn a = new jn();
    private float c = 0.0f;
    private int d = 0;
    private boolean e = false;

    public void a(float f) {
        this.c = f;
    }

    public void a(int i) {
        this.d = i;
    }

    protected void a(View view, boolean z) {
        a(null);
        this.e = false;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        jn jnVar = new jn(view, motionEvent);
        if (esVar instanceof ce) {
            ce ceVar = (ce) esVar;
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
                double d = d(this.a.a(0, new PointF()), this.a.a(1, new PointF()));
                double d2 = d(jnVar.a(0, new PointF()), jnVar.a(1, new PointF()));
                if (this.e) {
                    float f = (float) (d2 / d);
                    PointF pointF = new PointF((jnVar.c(0) + jnVar.c(1)) / 2.0f, (jnVar.d(0) + jnVar.d(1)) / 2.0f);
                    jnVar.a(pointF);
                    if (Float.compare(Math.abs(f - 1.0f), this.c) >= 0) {
                        ceVar.a(this, view, pointF, f);
                        a(jnVar);
                        return;
                    }
                    return;
                } else if (Math.abs(d2 - d) > ((double) this.d)) {
                    a(jnVar);
                    this.e = true;
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
