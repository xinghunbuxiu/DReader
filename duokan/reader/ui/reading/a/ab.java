package com.duokan.reader.ui.reading.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Pair;
import android.view.View;

import com.duokan.core.ui.onTapListener;
import com.duokan.core.ui.er;
import com.duokan.reader.ui.reading.gs;

class ab implements onTapListener {
    final /* synthetic */ ac a;
    final /* synthetic */ aa b;

    ab(aa aaVar, ac acVar) {
        this.b = aaVar;
        this.a = acVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        Pair b = this.b.a.b(new Point(Math.round(pointF.x), Math.round(pointF.y)));
        if (b != null) {
            this.a.a(b, ((gs) b.first).getPageDrawable().j(((Integer) b.second).intValue()));
            this.b.d(true);
        }
    }
}
