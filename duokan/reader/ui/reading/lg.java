package com.duokan.reader.ui.reading;

import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.ZoomView.ZoomState;
import com.duokan.core.ui.ge;

class lg implements ge {
    final /* synthetic */ lb a;
    private float b = 1.0f;

    lg(lb lbVar) {
        this.a = lbVar;
    }

    public void a(ZoomView zoomView, ZoomState zoomState, ZoomState zoomState2) {
        fu activeImageView = this.a.getActiveImageView();
        if (zoomState == ZoomState.PINCH && activeImageView != null && !this.a.c.a()) {
            this.a.d();
        }
    }

    public void a(ZoomView zoomView) {
        if (this.a.h != null) {
            fy fyVar = (fy) zoomView;
            if (fyVar.getZoomState() == ZoomState.PINCH || fyVar.k()) {
                float f = this.b;
                float zoomFactor = this.a.h.getZoomFactor();
                if (((double) zoomFactor) > 1.1d * ((double) f)) {
                    this.a.c.c();
                    this.a.h.e();
                    this.b = zoomFactor;
                } else if (((double) zoomFactor) < 0.9d * ((double) f)) {
                    if (Float.compare(1.0f, zoomFactor) >= 0) {
                        this.a.c.d();
                        this.a.h.d();
                    }
                    this.b = zoomFactor;
                } else {
                    fyVar.setToBeQuit(!this.a.c.a());
                }
            }
        }
    }
}
