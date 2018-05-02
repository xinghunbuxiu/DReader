package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.store.am;

class hj implements am {
    final /* synthetic */ DkStoreBookDetail a;
    final /* synthetic */ hh b;

    hj(hh hhVar, DkStoreBookDetail dkStoreBookDetail) {
        this.b = hhVar;
        this.a = dkStoreBookDetail;
    }

    public void a() {
        ay.a(this.b.a.f.b.pageController.getContext(), 0, new hk(this));
    }

    public void b() {
    }
}
