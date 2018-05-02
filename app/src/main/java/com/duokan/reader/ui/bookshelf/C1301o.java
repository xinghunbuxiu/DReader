package com.duokan.reader.ui.bookshelf;

import android.view.View;
import com.duokan.reader.domain.bookshelf.C0800c;

/* renamed from: com.duokan.reader.ui.bookshelf.o */
class C1301o implements bn {
    /* renamed from: a */
    final /* synthetic */ C1290g f6727a;

    C1301o(C1290g c1290g) {
        this.f6727a = c1290g;
    }

    /* renamed from: a */
    public void mo1725a(C0800c c0800c, View view) {
        this.f6727a.f6481a.openBook(c0800c);
    }

    /* renamed from: a */
    public void mo1726a(C0800c c0800c, View view, bo boVar, Runnable runnable) {
        this.f6727a.f6482b.m9436a(this.f6727a.getContext(), c0800c, new C1302p(this, boVar, runnable));
    }
}
