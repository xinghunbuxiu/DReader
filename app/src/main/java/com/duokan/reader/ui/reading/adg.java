package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.au;

class adg implements au {
    /* renamed from: a */
    final /* synthetic */ ade f9513a;

    adg(ade ade) {
        this.f9513a = ade;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1681a(View view, PointF pointF, int i) {
        this.f9513a.f9507a.m12551a(new Point((int) pointF.x, (int) pointF.y), new Rect(0, 0, view.getWidth(), view.getHeight()), view);
    }
}
