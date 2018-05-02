package com.duokan.reader.ui.p049a;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.duokan.reader.ui.a.o */
class C1229o implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1221u f5729a;
    /* renamed from: b */
    final /* synthetic */ C1228n f5730b;

    C1229o(C1228n c1228n, C1221u c1221u) {
        this.f5730b = c1228n;
        this.f5729a = c1221u;
    }

    public void onClick(View view) {
        this.f5730b.requestDetach();
        this.f5729a.mo1551a();
    }
}
