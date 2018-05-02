package com.duokan.reader.ui.store;

import android.content.Context;
import com.duokan.reader.domain.store.C1187m;
import com.duokan.reader.domain.store.C1192r;
import com.duokan.reader.domain.store.DkStoreCallback;

/* renamed from: com.duokan.reader.ui.store.v */
class C1509v extends C1192r {
    /* renamed from: a */
    final /* synthetic */ C1187m f11477a;
    /* renamed from: b */
    final /* synthetic */ String f11478b;
    /* renamed from: c */
    final /* synthetic */ DkStoreCallback f11479c;
    /* renamed from: d */
    final /* synthetic */ C1502o f11480d;

    C1509v(C1502o c1502o, Context context, C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        this.f11480d = c1502o;
        this.f11477a = c1187m;
        this.f11478b = str;
        this.f11479c = dkStoreCallback;
        super(context);
    }

    /* renamed from: a */
    public void mo2541a() {
        super.mo2541a();
        this.f11480d.m15423c(this.f11477a, this.f11478b, this.f11479c);
    }

    public void onCancel() {
        super.onCancel();
        this.f11479c.mo1164a(this.f11477a, "");
    }
}
