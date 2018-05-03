package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.AnimUtils;

class dl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dg f10030a;

    dl(dg dgVar) {
        this.f10030a = dgVar;
    }

    public void run() {
        try {
            Rect rect = new Rect();
            if (this.f10030a.getLocalVisibleRect(rect) && this.f10030a.f10005f.mo2004U() != PageAnimationMode.VSCROLL) {
                long currentTimeMillis = System.currentTimeMillis();
                for (View view : this.f10030a.f10022w.keySet()) {
                    if (view.getVisibility() == 0 && view.getLocalVisibleRect(rect) && rect.height() > AnimUtils.m1932b(this.f10030a.getContext(), 50.0f)) {
                        this.f10030a.f10002c.put(this.f10030a.f10022w.get(view), Long.valueOf(currentTimeMillis));
                    }
                }
                if (this.f10030a.f10021v.getVisibility() == 0 && this.f10030a.f10021v.getLocalVisibleRect(rect) && rect.height() > AnimUtils.m1932b(this.f10030a.getContext(), 50.0f)) {
                    this.f10030a.f10002c.put("related_to_store_button", Long.valueOf(System.currentTimeMillis()));
                }
            }
        } catch (Throwable th) {
        }
    }
}
