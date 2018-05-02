package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.duokan.reader.ui.reading.m */
class C1462m implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1460k f10605a;

    C1462m(C1460k c1460k) {
        this.f10605a = c1460k;
    }

    public void onClick(View view) {
        this.f10605a.f10484b.cancel();
        if (this.f10605a.f10486d != null) {
            this.f10605a.f10486d.mo2507a();
        }
    }
}
