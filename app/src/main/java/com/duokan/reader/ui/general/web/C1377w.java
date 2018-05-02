package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.C1185k;

/* renamed from: com.duokan.reader.ui.general.web.w */
class C1377w implements C1185k {
    /* renamed from: a */
    final /* synthetic */ Runnable f8180a;
    /* renamed from: b */
    final /* synthetic */ SearchController f8181b;

    C1377w(SearchController searchController, Runnable runnable) {
        this.f8181b = searchController;
        this.f8180a = runnable;
    }

    /* renamed from: a */
    public void mo1858a(String str, String[] strArr) {
        if (this.f8181b.isActive()) {
            this.f8181b.showHint(str, strArr);
        }
        this.f8180a.run();
    }

    /* renamed from: a */
    public void mo1857a(String str) {
        this.f8180a.run();
    }
}
