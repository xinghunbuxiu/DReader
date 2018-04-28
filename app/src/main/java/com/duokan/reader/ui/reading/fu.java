package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import com.duokan.reader.domain.document.bb;
import org.apache.http.HttpStatus;

class fu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bb f10186a;
    /* renamed from: b */
    final /* synthetic */ fs f10187b;

    fu(fs fsVar, bb bbVar) {
        this.f10187b = fsVar;
        this.f10186a = bbVar;
    }

    public void run() {
        Rect[] b = this.f10187b.mo2107b(this.f10186a);
        Rect rect = new Rect();
        for (Rect union : b) {
            rect.union(union);
        }
        this.f10187b.m9992a(this.f10187b.m9986a(rect), this.f10187b.getViewableBounds(), (int) HttpStatus.SC_OK, null, null);
    }
}
