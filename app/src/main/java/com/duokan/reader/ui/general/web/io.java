package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class io implements h {
    final /* synthetic */ in a;

    io(in inVar) {
        this.a = inVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        Object a = ai.a().a((DkStoreFictionDetail) dkStoreItem);
        a.j(this.a.b);
        this.a.c.a(a);
        synchronized (this.a.c) {
            this.a.c.notify();
        }
    }

    public void onFetchBookDetailError(String str) {
        this.a.d.b.pageController.doShowToast(str);
        synchronized (this.a.c) {
            this.a.c.notify();
        }
    }
}
