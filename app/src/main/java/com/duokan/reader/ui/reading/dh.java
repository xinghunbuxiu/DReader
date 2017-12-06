package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.UTools;

class dh implements Runnable {
    final /* synthetic */ de a;

    dh(de deVar) {
        this.a = deVar;
    }

    public void run() {
        try {
            Rect rect = new Rect();
            if (this.a.getLocalVisibleRect(rect) && this.a.e.U() != PageAnimationMode.VSCROLL) {
                long currentTimeMillis = System.currentTimeMillis();
                for (View view : this.a.v.keySet()) {
                    if (view.getVisibility() == 0 && view.getLocalVisibleRect(rect) && rect.height() > UTools.getMinimumHeight(this.a.getContext(), 50.0f)) {
                        this.a.c.put(this.a.v.get(view), Long.valueOf(currentTimeMillis));
                    }
                }
                if (this.a.u.getVisibility() == 0 && this.a.u.getLocalVisibleRect(rect) && rect.height() > UTools.getMinimumHeight(this.a.getContext(), 50.0f)) {
                    this.a.c.put("related_to_store_button", Long.valueOf(System.currentTimeMillis()));
                }
            }
        } catch (Throwable th) {
        }
    }
}
