package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cc;

class lv implements cc {
    /* renamed from: a */
    final /* synthetic */ float[] f10592a;
    /* renamed from: b */
    final /* synthetic */ PointF f10593b;
    /* renamed from: c */
    final /* synthetic */ lt f10594c;

    lv(lt ltVar, float[] fArr, PointF pointF) {
        this.f10594c = ltVar;
        this.f10592a = fArr;
        this.f10593b = pointF;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo538a(View view, PointF pointF, float f) {
        this.f10592a[0] = f;
        this.f10593b.x = pointF.x;
        this.f10593b.y = pointF.y;
    }
}
