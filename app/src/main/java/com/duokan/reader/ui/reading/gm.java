package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class gm implements du {
    /* renamed from: a */
    final /* synthetic */ gk f10249a;

    gm(gk gkVar) {
        this.f10249a = gkVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (!this.f10249a.f10245d && Float.compare(this.f10249a.f10243a.mo2421i(), this.f10249a.f10243a.getZoomFactor()) == 0) {
            this.f10249a.f10245d = true;
            this.f10249a.m1617c(true);
            this.f10249a.f10243a.setPullingDown(true);
        }
        if (this.f10249a.f10245d) {
            this.f10249a.f10244c = this.f10249a.f10244c + ((int) pointF2.y);
            float max = Math.max(-1.0f, Math.min(1.0f, ((float) this.f10249a.f10244c) / ((float) this.f10249a.f10243a.getHeight())));
            this.f10249a.f10243a.m1350a((float) (this.f10249a.f10243a.f10223c.getWidth() / 2), ((float) (this.f10249a.f10243a.f10223c.getHeight() / 2)) - (max * ((float) this.f10249a.f10243a.getHeight())), Math.max(this.f10249a.f10243a.mo2421i() * (1.0f - Math.abs(max)), this.f10249a.f10243a.getMinZoomFactor() * 0.5f));
        }
    }
}
