package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class dd implements as {
    /* renamed from: a */
    final /* synthetic */ String f7718a;
    /* renamed from: b */
    final /* synthetic */ ci f7719b;

    dd(ci ciVar, String str) {
        this.f7719b = ciVar;
        this.f7718a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        StorePageController.mBackParam = this.f7718a;
        this.f7719b.f7581b.requestDetach();
    }
}
