package com.duokan.reader.ui.personal;

import com.duokan.c.j;

class li implements Runnable {
    final /* synthetic */ lh a;

    li(lh lhVar) {
        this.a = lhVar;
    }

    public void run() {
        this.a.a.d.a = this.a.a.a;
        this.a.a.d.c = this.a.a.b;
        this.a.a.d.d = this.a.a.c;
        this.a.a.d.a(false);
        this.a.a.d.b(true);
        this.a.a.e.f.setHint(String.format(this.a.a.e.getContext().getString(j.bookshelf__purchased_books_view__search_book_count), new Object[]{Integer.valueOf((this.a.a.d.a.size() + this.a.a.d.c.size()) + this.a.a.d.d.size())}));
    }
}
