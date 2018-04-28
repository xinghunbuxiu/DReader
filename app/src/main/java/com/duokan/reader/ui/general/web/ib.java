package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.account.ab;

class ib implements as {
    /* renamed from: a */
    final /* synthetic */ String f7965a;
    /* renamed from: b */
    final /* synthetic */ String f7966b;
    /* renamed from: c */
    final /* synthetic */ String f7967c;
    /* renamed from: d */
    final /* synthetic */ String f7968d;
    /* renamed from: e */
    final /* synthetic */ String f7969e;
    /* renamed from: f */
    final /* synthetic */ String f7970f;
    /* renamed from: g */
    final /* synthetic */ String f7971g;
    /* renamed from: h */
    final /* synthetic */ String f7972h;
    /* renamed from: i */
    final /* synthetic */ String f7973i;
    /* renamed from: j */
    final /* synthetic */ String[] f7974j;
    /* renamed from: k */
    final /* synthetic */ String[] f7975k;
    /* renamed from: l */
    final /* synthetic */ String f7976l;
    /* renamed from: m */
    final /* synthetic */ ia f7977m;

    ib(ia iaVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String[] strArr, String[] strArr2, String str10) {
        this.f7977m = iaVar;
        this.f7965a = str;
        this.f7966b = str2;
        this.f7967c = str3;
        this.f7968d = str4;
        this.f7969e = str5;
        this.f7970f = str6;
        this.f7971g = str7;
        this.f7972h = str8;
        this.f7973i = str9;
        this.f7974j = strArr;
        this.f7975k = strArr2;
        this.f7976l = str10;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7977m.f7964b.f7581b.mShareController != null) {
            this.f7977m.f7964b.f7581b.deactivate(this.f7977m.f7964b.f7581b.mShareController);
            this.f7977m.f7964b.f7581b.removeSubController(this.f7977m.f7964b.f7581b.mShareController);
        }
        new ab(this.f7977m.f7964b.f7581b.getContext(), false, new id(this, new ic(this))).show();
    }
}
