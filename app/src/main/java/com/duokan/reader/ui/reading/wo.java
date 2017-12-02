package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;

class wo implements Runnable {
    final /* synthetic */ wl a;

    wo(wl wlVar) {
        this.a = wlVar;
    }

    public void run() {
        Drawable drawable = null;
        if (this.a.h == null) {
            Drawable drawable2;
            this.a.g = this.a.c();
            if (this.a.g != null) {
                drawable2 = null;
            } else {
                drawable2 = new gm(this.a.getContext());
                drawable2.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
                drawable = this.a.a.S();
                drawable.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
            }
            this.a.h = new wp(this, drawable, drawable2);
            this.a.h.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
        }
    }
}
