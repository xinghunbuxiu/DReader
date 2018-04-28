package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;

class ba implements cu {
    /* renamed from: a */
    final /* synthetic */ az f9817a;

    ba(az azVar) {
        this.f9817a = azVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.f9817a.f9812a.requestShowMenu();
        this.f9817a.m1620d(true);
    }
}
