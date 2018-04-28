package com.duokan.reader.ui.store;

import com.duokan.core.app.AppContext;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.ui.general.ja;

final class ar implements C0517a {
    /* renamed from: a */
    final /* synthetic */ AppContext f11323a;
    /* renamed from: b */
    final /* synthetic */ ee f11324b;
    /* renamed from: c */
    final /* synthetic */ ax f11325c;

    ar(AppContext appContext, ee eeVar, ax axVar) {
        this.f11323a = appContext;
        this.f11324b = eeVar;
        this.f11325c = axVar;
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
    }

    /* renamed from: a */
    public void mo730a(Object obj) {
        ja jaVar = new ja(this.f11323a);
        jaVar.m10843a(this.f11323a.getString(C0247i.bookcity_store__shared__creating_order));
        jaVar.m10844a(true);
        jaVar.setCancelOnBack(false);
        jaVar.setCancelOnTouchOutside(false);
        jaVar.show();
        C1502o.m15410a().m15433a(this.f11324b.m4156I(), false, false, -1, -1, -1, new as(this, jaVar));
    }
}
