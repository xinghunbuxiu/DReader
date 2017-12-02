package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.et;

class xr extends er {
    final /* synthetic */ xq a;

    xr(xq xqVar) {
        this.a = xqVar;
    }

    protected void a(View view, boolean z) {
        if (!this.a.a.K()) {
            et zoomDetector = ((gs) this.a.a.X().d()).getZoomDetector();
            if (zoomDetector != null) {
                zoomDetector.a(view);
            }
        }
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!this.a.a.K()) {
            et zoomDetector = ((gs) this.a.a.X().d()).getZoomDetector();
            if (zoomDetector != null) {
                zoomDetector.onTouch(view, motionEvent);
                c(zoomDetector.a() != null);
            }
        }
    }
}
