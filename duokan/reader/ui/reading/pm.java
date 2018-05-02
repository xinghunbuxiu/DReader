package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.ZoomView;

class pm implements OnClickListener {
    final /* synthetic */ ZoomView a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ pc c;

    pm(pc pcVar, ZoomView zoomView, Runnable runnable) {
        this.c = pcVar;
        this.a = zoomView;
        this.b = runnable;
    }

    public void onClick(View view) {
        if (Float.compare(this.a.getZoomFactor(), 1.0f) > 0) {
            this.a.b(0.0f, 0.0f, 1.0f, null, null);
        } else {
            this.b.run();
        }
    }
}
