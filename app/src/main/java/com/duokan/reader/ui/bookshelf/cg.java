package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;

class cg implements du {
    /* renamed from: a */
    final /* synthetic */ ce f6269a;

    cg(ce ceVar) {
        this.f6269a = ceVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (this.f6269a.f6255g) {
            dv.m1946c(pointF2, view);
            this.f6269a.f6256h.m9424a((int) pointF2.x, (int) pointF2.y);
            this.f6269a.m9395g(true);
        }
    }
}
