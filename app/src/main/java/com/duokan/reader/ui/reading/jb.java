package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;
import com.duokan.reader.ui.reading.FixedPageClipView.ClipIndicator;

class jb implements du {
    /* renamed from: a */
    final /* synthetic */ iz f10421a;

    jb(iz izVar) {
        this.f10421a = izVar;
    }

    public void onTouchUp(View view, PointF pointF) {
        this.f10421a.f10417d = ClipIndicator.UNKNOW;
        this.f10421a.f10416c.m12417a(this.f10421a.f10417d, pointF, 1);
    }

    public void onTouchDown(View view, PointF pointF) {
        this.f10421a.f10416c.requestDisallowInterceptTouchEvent(true);
        this.f10421a.f10417d = this.f10421a.f10416c.m12416a(pointF);
        this.f10421a.f10416c.m12417a(this.f10421a.f10417d, pointF, 1);
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.f10421a.f10416c.m12417a(this.f10421a.f10417d, pointF2, 2);
    }
}
