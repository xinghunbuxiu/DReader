package com.duokan.reader.ui.reading;

import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.ZoomView.ZoomState;
import com.duokan.core.ui.ge;

class mw implements ge {
    final /* synthetic */ mv a;

    mw(mv mvVar) {
        this.a = mvVar;
    }

    public void a(ZoomView zoomView, ZoomState zoomState, ZoomState zoomState2) {
        if (this.a.d != null) {
            this.a.d.a(zoomView, zoomState, zoomState2);
        }
        if (zoomState2 == ZoomState.PINCH && zoomState == ZoomState.IDLE) {
            this.a.f.b();
        } else if (!this.a.b) {
            this.a.f.a();
        }
    }

    public void a(ZoomView zoomView) {
        if (this.a.d != null) {
            this.a.d.a(zoomView);
        }
    }
}
