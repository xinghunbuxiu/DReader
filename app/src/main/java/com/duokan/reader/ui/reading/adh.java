package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.du;
import com.duokan.core.ui.er;

class adh implements du {
    /* renamed from: a */
    final /* synthetic */ ade f9514a;

    adh(ade ade) {
        this.f9514a = ade;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo527a(er erVar, View view, PointF pointF, PointF pointF2) {
        if (!this.f9514a.f9507a.m12576g() && this.f9514a.f9507a.m12570d() && !this.f9514a.f9507a.f9155d) {
            if (this.f9514a.f9507a.f9156e.ae().m12447H()) {
                this.f9514a.f9507a.m12552a(SelectionStyle.RAPID_SLIDE, view);
            } else {
                this.f9514a.f9507a.m12552a(SelectionStyle.FAST_SELECTING, view);
            }
        }
    }
}
