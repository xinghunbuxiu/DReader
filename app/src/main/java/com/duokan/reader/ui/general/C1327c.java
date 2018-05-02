package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import com.duokan.reader.common.cache.C0570b;
import com.duokan.reader.common.cache.C0571c;

/* renamed from: com.duokan.reader.ui.general.c */
class C1327c extends C0570b {
    /* renamed from: c */
    final /* synthetic */ C1326b f7018c;
    /* renamed from: d */
    private final C0571c f7019d;

    public C1327c(C1326b c1326b, C1328d c1328d) {
        this.f7018c = c1326b;
        super(Math.round(c1328d.m2570b().width() * c1328d.m2571c()), Math.round(c1328d.m2570b().height() * c1328d.m2571c()), c1326b.f6954a);
        this.f7019d = c1328d;
    }

    /* renamed from: a */
    protected void mo1753a(Bitmap bitmap) {
        this.f7018c.mo2512a(bitmap, this.f7019d.m2570b(), this.f7019d.m2571c());
    }

    /* renamed from: m */
    protected void mo1754m() {
    }
}
