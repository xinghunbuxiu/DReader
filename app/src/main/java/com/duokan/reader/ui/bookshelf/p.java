package com.duokan.reader.ui.bookshelf;

import android.view.View;

import com.duokan.reader.domain.bookshelf.c;

class p implements bh {
    final /* synthetic */ g a;

    p(g gVar) {
        this.a = gVar;
    }

    public void a(c cVar, View view) {
        this.a.a.openBook(cVar);
    }

    public void a(c cVar, View view, bi biVar, Runnable runnable) {
        this.a.b.a(this.a.getContext(), cVar, new q(this, biVar, runnable));
    }
}
