package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0385i;
import com.duokan.core.ui.er;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

class cy implements C0385i {
    /* renamed from: a */
    final /* synthetic */ cx f9970a;

    cy(cx cxVar) {
        this.f9970a = cxVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1788a(er erVar, View view, PointF pointF, int i) {
        if (this.f9970a.f9969d != null) {
            ((C1540p) this.f9970a.f9967a.getContext().queryFeature(C1540p.class)).mo2564a(this.f9970a.f9967a.getContext(), UserInput.READING_SHOW_CARTOON_GESTURE);
            this.f9970a.f9967a.m13870b(((gx) this.f9970a.f9969d.first).getPageDrawable().mo1352v(((Integer) this.f9970a.f9969d.second).intValue()));
            this.f9970a.m1620d(true);
            this.f9970a.m1613b(false);
        }
    }
}
