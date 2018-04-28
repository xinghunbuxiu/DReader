package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class abx implements du {
    /* renamed from: a */
    final /* synthetic */ abv f9432a;

    abx(abv abv) {
        this.f9432a = abv;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        this.f9432a.f9430h = true;
        PointF a = this.f9432a.f9428f;
        a.x += pointF2.x;
        pointF.offset(pointF2.x, pointF2.y);
        if (this.f9432a.f9424a.f9387i == null) {
            this.f9432a.f9424a.f9382d.onDragMove(pointF);
        }
    }
}
