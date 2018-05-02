package com.duokan.reader.ui.reading;

import android.graphics.Rect;

/* renamed from: com.duokan.reader.ui.reading.w */
class C1472w implements ady {
    /* renamed from: a */
    final /* synthetic */ C1468s f11096a;

    C1472w(C1468s c1468s) {
        this.f11096a = c1468s;
    }

    /* renamed from: a */
    public void mo2219a() {
        this.f11096a.f10927d.show();
        if (this.f11096a.f10925b == null || this.f11096a.f10925b.length <= 0) {
            Rect b = this.f11096a.f10928e.getDocument().mo1245k().m6084b();
            this.f11096a.f10924a.m15210b(b);
            return;
        }
        this.f11096a.f10924a.m15210b(this.f11096a.f10925b);
    }

    /* renamed from: b */
    public void mo2220b() {
        this.f11096a.f10927d.show();
        if (this.f11096a.f10925b == null || this.f11096a.f10925b.length <= 0) {
            Rect b = this.f11096a.f10928e.getDocument().mo1245k().m6084b();
            this.f11096a.f10924a.m15205a(b);
            return;
        }
        this.f11096a.f10924a.m15205a(this.f11096a.f10925b);
    }
}
