package com.duokan.reader.ui.general;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

class ij implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ViewGroup f7380a;
    /* renamed from: b */
    final /* synthetic */ int f7381b;
    /* renamed from: c */
    final /* synthetic */ ii f7382c;

    ij(ii iiVar, ViewGroup viewGroup, int i) {
        this.f7382c = iiVar;
        this.f7380a = viewGroup;
        this.f7381b = i;
    }

    public void run() {
        this.f7380a.removeViewInLayout(this.f7382c);
        LayoutParams layoutParams = this.f7382c.getLayoutParams();
        if (layoutParams != null) {
            this.f7380a.addView(this.f7382c.f7379b, this.f7381b, layoutParams);
        } else {
            this.f7380a.addView(this.f7382c.f7379b, this.f7381b);
        }
    }
}
