package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class aby implements du {
    /* renamed from: a */
    final /* synthetic */ abv f9433a;

    aby(abv abv) {
        this.f9433a = abv;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.f9433a.f9429g = this.f9433a.f9429g + pointF2.x;
        if (((!this.f9433a.f9424a.f9379a.al() || pointF2.x >= 0.0f) && (this.f9433a.f9424a.f9379a.al() || pointF2.x <= 0.0f)) || this.f9433a.f9424a.f9379a.mo2135d(this.f9433a.f9424a.f9379a.mo2009Z())) {
            if (((this.f9433a.f9424a.f9379a.al() && pointF2.x > 0.0f) || (!this.f9433a.f9424a.f9379a.al() && pointF2.x < 0.0f)) && !this.f9433a.f9424a.f9379a.ax()) {
                if (this.f9433a.f9424a.m13224h()) {
                    this.f9433a.f9430h = true;
                    this.f9433a.f9427e = pointF;
                    this.f9433a.m1617c(true);
                    this.f9433a.f9424a.f9387i = new aca(this);
                    this.f9433a.f9424a.m13212c(1);
                    return;
                }
                this.f9433a.m1613b(false);
                this.f9433a.m1620d(true);
            }
        } else if (!this.f9433a.f9424a.f9379a.aw()) {
            if (this.f9433a.f9424a.m13226i()) {
                this.f9433a.f9430h = true;
                this.f9433a.f9427e = pointF;
                this.f9433a.m1617c(true);
                this.f9433a.f9424a.f9387i = new abz(this);
                this.f9433a.f9424a.m13212c(-1);
                return;
            }
            this.f9433a.m1613b(false);
            this.f9433a.m1620d(true);
        }
    }
}
