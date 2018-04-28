package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;

class xb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ wy f11135a;

    xb(wy wyVar) {
        this.f11135a = wyVar;
    }

    public void run() {
        Drawable drawable = null;
        if (this.f11135a.f9705h == null) {
            Drawable drawable2;
            this.f11135a.f9704g = this.f11135a.mo2466c();
            if (this.f11135a.f9704g != null) {
                drawable2 = null;
            } else {
                drawable2 = new gr(this.f11135a.getContext());
                drawable2.setBounds(0, 0, this.f11135a.getWidth(), this.f11135a.getHeight());
                drawable = this.f11135a.f9698a.mo2002S();
                drawable.setBounds(0, 0, this.f11135a.getWidth(), this.f11135a.getHeight());
            }
            this.f11135a.f9705h = new xc(this, drawable, drawable2);
            this.f11135a.f9705h.setBounds(0, 0, this.f11135a.getWidth(), this.f11135a.getHeight());
        }
    }
}
