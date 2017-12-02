package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.i;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

class cw implements i {
    final /* synthetic */ cv a;

    cw(cv cvVar) {
        this.a = cvVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, int i) {
        if (this.a.d != null) {
            ((p) this.a.a.getContext().queryFeature(p.class)).a(this.a.a.getContext(), UserInput.READING_SHOW_CARTOON_GESTURE);
            this.a.a.b(((gs) this.a.d.first).getPageDrawable().v(((Integer) this.a.d.second).intValue()));
            this.a.d(true);
            this.a.b(false);
        }
    }
}
