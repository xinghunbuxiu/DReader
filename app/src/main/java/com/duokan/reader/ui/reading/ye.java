package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.et;

class ye extends er {
    /* renamed from: a */
    final /* synthetic */ yd f11186a;

    ye(yd ydVar) {
        this.f11186a = ydVar;
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        if (!this.f11186a.a.mo1994K()) {
            et zoomDetector = ((gx) this.f11186a.a.mo2007X().mo2328d()).getZoomDetector();
            if (zoomDetector != null) {
                zoomDetector.m2040a(view);
            }
        }
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.f11186a.a.mo1994K()) {
            et zoomDetector = ((gx) this.f11186a.a.mo2007X().mo2328d()).getZoomDetector();
            if (zoomDetector != null) {
                zoomDetector.onTouch(view, motionEvent);
                m1617c(zoomDetector.m2039a() != null);
            }
        }
    }
}
