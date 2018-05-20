package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.Scrollable.OverScrollMode;

class gj implements cc {
    
    final  View f1320a;
    
    final  gh f1321b;

    gj(gh ghVar, View view) {
        this.f1321b = ghVar;
        this.f1320a = view;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    
    public void mo538a(View view, PointF pointF, float f) {
        if (!this.f1321b.f1314g) {
            this.f1321b.f1309a.f870b.setHorizontalOverScrollMode(OverScrollMode.NEVER);
            this.f1321b.f1309a.f870b.setVerticalOverScrollMode(OverScrollMode.NEVER);
            this.f1321b.f1313f.set(pointF.x + ((float) this.f1321b.f1309a.getScrollX()), pointF.y + ((float) this.f1321b.f1309a.getScrollY()));
            AnimUtils.m1900a(this.f1321b.f1313f, this.f1321b.f1309a, this.f1320a);
            this.f1321b.f1314g = true;
            this.f1321b.f1316i = this.f1321b.f1309a.getZoomFactor();
            this.f1321b.m1617c(true);
        }
        this.f1321b.f1317j = this.f1321b.f1309a.getZoomAngle() + f;
        this.f1321b.f1315h.set(pointF);
    }
}
