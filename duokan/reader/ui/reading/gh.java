package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class gh implements du {
    final /* synthetic */ gf a;

    gh(gf gfVar) {
        this.a = gfVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (!this.a.d && Float.compare(this.a.a.i(), this.a.a.getZoomFactor()) == 0) {
            this.a.d = true;
            this.a.c(true);
            this.a.a.setPullingDown(true);
        }
        if (this.a.d) {
            this.a.c = this.a.c + ((int) pointF2.y);
            float max = Math.max(-1.0f, Math.min(1.0f, ((float) this.a.c) / ((float) this.a.a.getHeight())));
            this.a.a.a((float) (this.a.a.c.getWidth() / 2), ((float) (this.a.a.c.getHeight() / 2)) - (max * ((float) this.a.a.getHeight())), Math.max(this.a.a.i() * (1.0f - Math.abs(max)), this.a.a.getMinZoomFactor() * 0.5f));
        }
    }
}
