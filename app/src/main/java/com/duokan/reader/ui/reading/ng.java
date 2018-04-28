package com.duokan.reader.ui.reading;

import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.ZoomView.ZoomState;
import com.duokan.core.ui.ge;

class ng implements ge {
    /* renamed from: a */
    final /* synthetic */ nf f10666a;

    ng(nf nfVar) {
        this.f10666a = nfVar;
    }

    /* renamed from: a */
    public void mo2424a(ZoomView zoomView, ZoomState zoomState, ZoomState zoomState2) {
        if (this.f10666a.f10662d != null) {
            this.f10666a.f10662d.mo2424a(zoomView, zoomState, zoomState2);
        }
        if (zoomState2 == ZoomState.PINCH && zoomState == ZoomState.IDLE) {
            this.f10666a.f10664f.mo2433b();
        } else if (!this.f10666a.f10661b) {
            this.f10666a.f10664f.mo2431a();
        }
    }

    /* renamed from: a */
    public void mo2423a(ZoomView zoomView) {
        if (this.f10666a.f10662d != null) {
            this.f10666a.f10662d.mo2423a(zoomView);
        }
    }
}
