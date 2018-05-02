package com.duokan.reader.ui.reading;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

/* renamed from: com.duokan.reader.ui.reading.p */
class C1465p implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ C1460k f10770a;

    C1465p(C1460k c1460k) {
        this.f10770a = c1460k;
    }

    public void onCancel(C0301c c0301c) {
        if (this.f10770a.f10486d != null) {
            this.f10770a.f10486d.mo2507a();
        }
    }
}
