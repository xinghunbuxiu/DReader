package com.duokan.reader.ui.reading;

import android.graphics.PointF;

import com.duokan.reader.ui.reading.a.f;

class jh implements f {
    final /* synthetic */ jd a;
    final /* synthetic */ jg b;

    jh(jg jgVar, jd jdVar) {
        this.b = jgVar;
        this.a = jdVar;
    }

    public boolean a() {
        return this.b.getVisibility() == 0;
    }

    public void b() {
        this.b.j = this.b.getWidth();
        this.b.a(0, 0, 0, null);
    }

    public void a(float f, float f2) {
        int a = this.b.j + ((int) f);
        if (this.b.b == 0) {
            this.b.j = Math.min(this.b.getWidth(), Math.max(0, a));
        } else {
            this.b.j = Math.min(this.b.getWidth() * 2, Math.max(this.b.getWidth(), a));
        }
        this.b.a(this.b.getWidth() - this.b.j, this.b.getWidth() - this.b.j, 0, null);
    }

    public void a(boolean z) {
        Runnable jiVar = new ji(this);
        this.b.f = z;
        if (this.b.b == 0) {
            if (this.b.f) {
                this.b.a(this.b.getWidth() - this.b.j, 0, Math.abs(Math.round(((((float) (this.b.getWidth() - this.b.j)) * 1.0f) / ((float) this.b.getWidth())) * 300.0f)), jiVar);
                return;
            }
            this.b.a(this.b.getWidth() - this.b.j, this.b.getWidth(), Math.abs(Math.round(((((float) this.b.j) * 1.0f) / ((float) this.b.getWidth())) * 300.0f)), jiVar);
        } else if (this.b.f) {
            this.b.a(this.b.getWidth() - this.b.j, 0, Math.abs(Math.round(((((float) (this.b.getWidth() - this.b.j)) * 1.0f) / ((float) this.b.getWidth())) * 300.0f)), jiVar);
        } else {
            this.b.a(this.b.getWidth() - this.b.j, -this.b.getWidth(), Math.abs(Math.round(((((float) this.b.j) * 1.0f) / ((float) this.b.getWidth())) * 300.0f)), jiVar);
        }
    }

    public void a(PointF pointF) {
        boolean z = true;
        if (this.b.b == 0) {
            if (Float.compare(pointF.x, 0.0f) <= 0) {
                z = false;
            }
            a(z);
            return;
        }
        if (Float.compare(pointF.x, 0.0f) >= 0) {
            z = false;
        }
        a(z);
    }
}
