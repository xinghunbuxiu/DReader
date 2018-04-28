package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0382r;
import com.duokan.core.ui.er;

class abw implements C0382r {
    /* renamed from: a */
    final /* synthetic */ abv f9431a;

    abw(abv abv) {
        this.f9431a = abv;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo528a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f9431a.f9424a.f9387i != null) {
            this.f9431a.f9424a.m13232l();
        } else {
            this.f9431a.f9424a.f9382d.onDragEnd(pointF, pointF2);
        }
        this.f9431a.f9430h = false;
        this.f9431a.m1620d(true);
    }
}
