package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;

class lx implements cu {
    /* renamed from: a */
    final /* synthetic */ boolean[] f10598a;
    /* renamed from: b */
    final /* synthetic */ lt f10599b;

    lx(lt ltVar, boolean[] zArr) {
        this.f10599b = ltVar;
        this.f10598a = zArr;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.f10598a[0] = true;
    }
}
