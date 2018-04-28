package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;

class lw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ lv f8913a;

    lw(lv lvVar) {
        this.f8913a = lvVar;
    }

    public void run() {
        this.f8913a.f8912a.f8910d.f8822a = this.f8913a.f8912a.f8907a;
        this.f8913a.f8912a.f8910d.f8823c = this.f8913a.f8912a.f8908b;
        this.f8913a.f8912a.f8910d.f8824d = this.f8913a.f8912a.f8909c;
        this.f8913a.f8912a.f8910d.m8785a(false);
        this.f8913a.f8912a.f8910d.mo1755b(true);
        this.f8913a.f8912a.f8911e.g.setHint(String.format(this.f8913a.f8912a.f8911e.getContext().getString(C0258j.bookshelf__purchased_books_view__search_book_count), new Object[]{Integer.valueOf((this.f8913a.f8912a.f8910d.f8822a.size() + this.f8913a.f8912a.f8910d.f8823c.size()) + this.f8913a.f8912a.f8910d.f8824d.size())}));
    }
}
