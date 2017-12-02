package com.duokan.reader.ui.reading;

import android.graphics.Rect;

import com.duokan.reader.domain.document.bb;

import org.apache.http.HttpStatus;

class fp implements Runnable {
    final /* synthetic */ bb a;
    final /* synthetic */ fo b;

    fp(fo foVar, bb bbVar) {
        this.b = foVar;
        this.a = bbVar;
    }

    public void run() {
        Rect[] b = this.b.b(this.a);
        Rect rect = new Rect();
        for (Rect union : b) {
            rect.union(union);
        }
        this.b.a(this.b.a(rect), this.b.getViewableBounds(), HttpStatus.SC_OK, null, null);
    }
}
