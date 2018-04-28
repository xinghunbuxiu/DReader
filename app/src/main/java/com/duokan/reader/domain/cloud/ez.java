package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.ja;

class ez implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkStoreBookDetail f3963a;
    /* renamed from: b */
    final /* synthetic */ fj f3964b;
    /* renamed from: c */
    final /* synthetic */ ja f3965c;
    /* renamed from: d */
    final /* synthetic */ ex f3966d;

    ez(ex exVar, DkStoreBookDetail dkStoreBookDetail, fj fjVar, ja jaVar) {
        this.f3966d = exVar;
        this.f3963a = dkStoreBookDetail;
        this.f3964b = fjVar;
        this.f3965c = jaVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3966d.m5520a(this.f3963a, this.f3964b, this.f3965c);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}
