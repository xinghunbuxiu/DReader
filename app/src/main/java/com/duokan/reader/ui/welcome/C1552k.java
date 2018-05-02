package com.duokan.reader.ui.welcome;

import android.view.ViewGroup;

/* renamed from: com.duokan.reader.ui.welcome.k */
class C1552k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ViewGroup f11622a;
    /* renamed from: b */
    final /* synthetic */ C1551j f11623b;

    C1552k(C1551j c1551j, ViewGroup viewGroup) {
        this.f11623b = c1551j;
        this.f11622a = viewGroup;
    }

    public void run() {
        this.f11622a.removeViewInLayout(this.f11623b.f11621e);
        this.f11623b.f11621e = null;
    }
}
