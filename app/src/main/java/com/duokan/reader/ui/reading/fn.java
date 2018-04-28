package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import com.duokan.reader.domain.document.bb;
import org.apache.http.HttpStatus;

class fn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bb f10162a;
    /* renamed from: b */
    final /* synthetic */ fm f10163b;

    fn(fm fmVar, bb bbVar) {
        this.f10163b = fmVar;
        this.f10162a = bbVar;
    }

    public void run() {
        Rect[] b = this.f10163b.mo2107b(this.f10162a);
        Rect rect = new Rect();
        for (Rect union : b) {
            rect.union(union);
        }
        this.f10163b.m9992a(this.f10163b.m9986a(rect), this.f10163b.getViewableBounds(), (int) HttpStatus.SC_OK, null, null);
    }
}
