package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import com.duokan.reader.ui.reading.p054a.C1425f;

class jr implements C1425f {
    /* renamed from: a */
    final /* synthetic */ jn f10465a;
    /* renamed from: b */
    final /* synthetic */ jq f10466b;

    jr(jq jqVar, jn jnVar) {
        this.f10466b = jqVar;
        this.f10465a = jnVar;
    }

    /* renamed from: a */
    public boolean mo2400a() {
        return this.f10466b.getVisibility() == 0;
    }

    /* renamed from: b */
    public void mo2401b() {
        this.f10466b.f10464j = this.f10466b.getWidth();
        this.f10466b.m14493a(0, 0, 0, null);
    }

    /* renamed from: a */
    public void mo2397a(float f, float f2) {
        int a = this.f10466b.f10464j + ((int) f);
        if (this.f10466b.f10456b == 0) {
            this.f10466b.f10464j = Math.min(this.f10466b.getWidth(), Math.max(0, a));
        } else {
            this.f10466b.f10464j = Math.min(this.f10466b.getWidth() * 2, Math.max(this.f10466b.getWidth(), a));
        }
        this.f10466b.m14493a(this.f10466b.getWidth() - this.f10466b.f10464j, this.f10466b.getWidth() - this.f10466b.f10464j, 0, null);
    }

    /* renamed from: a */
    public void mo2399a(boolean z) {
        Runnable jsVar = new js(this);
        this.f10466b.f10460f = z;
        if (this.f10466b.f10456b == 0) {
            if (this.f10466b.f10460f) {
                this.f10466b.m14493a(this.f10466b.getWidth() - this.f10466b.f10464j, 0, Math.abs(Math.round(((((float) (this.f10466b.getWidth() - this.f10466b.f10464j)) * 1.0f) / ((float) this.f10466b.getWidth())) * 300.0f)), jsVar);
                return;
            }
            this.f10466b.m14493a(this.f10466b.getWidth() - this.f10466b.f10464j, this.f10466b.getWidth(), Math.abs(Math.round(((((float) this.f10466b.f10464j) * 1.0f) / ((float) this.f10466b.getWidth())) * 300.0f)), jsVar);
        } else if (this.f10466b.f10460f) {
            this.f10466b.m14493a(this.f10466b.getWidth() - this.f10466b.f10464j, 0, Math.abs(Math.round(((((float) (this.f10466b.getWidth() - this.f10466b.f10464j)) * 1.0f) / ((float) this.f10466b.getWidth())) * 300.0f)), jsVar);
        } else {
            this.f10466b.m14493a(this.f10466b.getWidth() - this.f10466b.f10464j, -this.f10466b.getWidth(), Math.abs(Math.round(((((float) this.f10466b.f10464j) * 1.0f) / ((float) this.f10466b.getWidth())) * 300.0f)), jsVar);
        }
    }

    /* renamed from: a */
    public void mo2398a(PointF pointF) {
        boolean z = true;
        if (this.f10466b.f10456b == 0) {
            if (Float.compare(pointF.x, 0.0f) <= 0) {
                z = false;
            }
            mo2399a(z);
            return;
        }
        if (Float.compare(pointF.x, 0.0f) >= 0) {
            z = false;
        }
        mo2399a(z);
    }
}
