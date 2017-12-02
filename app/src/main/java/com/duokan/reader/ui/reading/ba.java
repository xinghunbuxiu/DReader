package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.cu;
import com.duokan.core.ui.er;

class ba implements cu {
    final /* synthetic */ az a;

    ba(az azVar) {
        this.a = azVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void onTap(er erVar, View view, PointF pointF) {
        this.a.a.requestShowMenu();
        this.a.d(true);
    }
}
