package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.ui.ZoomView;

class pw implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ZoomView f10837a;
    /* renamed from: b */
    final /* synthetic */ Runnable f10838b;
    /* renamed from: c */
    final /* synthetic */ pm f10839c;

    pw(pm pmVar, ZoomView zoomView, Runnable runnable) {
        this.f10839c = pmVar;
        this.f10837a = zoomView;
        this.f10838b = runnable;
    }

    public void onClick(View view) {
        if (Float.compare(this.f10837a.getZoomFactor(), 1.0f) > 0) {
            this.f10837a.m1360b(0.0f, 0.0f, 1.0f, null, null);
        } else {
            this.f10838b.run();
        }
    }
}
