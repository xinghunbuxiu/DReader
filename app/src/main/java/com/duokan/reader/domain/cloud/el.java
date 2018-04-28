package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;

class el implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ boolean f3931a;
    /* renamed from: b */
    final /* synthetic */ boolean f3932b;
    /* renamed from: c */
    final /* synthetic */ eu f3933c;
    /* renamed from: d */
    final /* synthetic */ DkUserReadingNotesManager f3934d;

    el(DkUserReadingNotesManager dkUserReadingNotesManager, boolean z, boolean z2, eu euVar) {
        this.f3934d = dkUserReadingNotesManager;
        this.f3931a = z;
        this.f3932b = z2;
        this.f3933c = euVar;
    }

    /* renamed from: a */
    public void m5498a(Void voidR) {
        DkUserPurchasedFictionsManager.m5072a().m5094a(new em(this));
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f3933c.mo1158a("");
    }
}
