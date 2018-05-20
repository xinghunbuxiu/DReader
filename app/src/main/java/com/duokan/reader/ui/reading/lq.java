package com.duokan.reader.ui.reading;

import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.ZoomView.ZoomState;
import com.duokan.core.ui.OnZoomListener;

class lq implements OnZoomListener {
    /* renamed from: a */
    final /* synthetic */ ll f10579a;
    /* renamed from: b */
    private float f10580b = 1.0f;

    lq(ll llVar) {
        this.f10579a = llVar;
    }

    /* renamed from: a */
    public void mo2424a(ZoomView zoomView, ZoomState zoomState, ZoomState zoomState2) {
        fz activeImageView = this.f10579a.getActiveImageView();
        if (zoomState == ZoomState.PINCH && activeImageView != null && !this.f10579a.f10251c.m14627a()) {
            this.f10579a.mo2343d();
        }
    }

    /* renamed from: a */
    public void onZoom(ZoomView zoomView) {
        if (this.f10579a.f10256h != null) {
            gd gdVar = (gd) zoomView;
            if (gdVar.getZoomState() == ZoomState.PINCH || gdVar.mo2415k()) {
                float f = this.f10580b;
                float zoomFactor = this.f10579a.f10256h.getZoomFactor();
                if (((double) zoomFactor) > 1.1d * ((double) f)) {
                    this.f10579a.f10251c.m14629c();
                    this.f10579a.f10256h.mo2471e();
                    this.f10580b = zoomFactor;
                } else if (((double) zoomFactor) < 0.9d * ((double) f)) {
                    if (Float.compare(1.0f, zoomFactor) >= 0) {
                        this.f10579a.f10251c.m14630d();
                        this.f10579a.f10256h.mo2470d();
                    }
                    this.f10580b = zoomFactor;
                } else {
                    gdVar.setToBeQuit(!this.f10579a.f10251c.m14627a());
                }
            }
        }
    }
}
