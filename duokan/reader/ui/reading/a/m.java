package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Pair;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.onTapListener;
import com.duokan.core.ui.er;

class m implements onTapListener {
    final /* synthetic */ n a;
    final /* synthetic */ l b;

    m(l lVar, n nVar) {
        this.b = lVar;
        this.a = nVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        Pair a = this.b.a.a(new Point((int) pointF.x, (int) pointF.y), UTools.getMinimumHeight(view.getContext(), 20.0f));
        if (a != null) {
            this.a.a(a);
            this.b.d(true);
        }
    }
}
