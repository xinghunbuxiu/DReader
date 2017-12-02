package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.b;

class hq implements mp {
    final /* synthetic */ Runnable a;
    final /* synthetic */ hl b;

    hq(hl hlVar, Runnable runnable) {
        this.b = hlVar;
        this.a = runnable;
    }

    public void a() {
        this.b.b.setLeftTitle(String.format(DkApp.get().getString(j.personal__readed_books_view__title), new Object[]{Long.valueOf(this.b.q.b())}));
        if (this.b.q.f() == 0.0d) {
            this.b.p.setText(this.b.a.getString(j.personal__experience_view__ranking_total_low));
        } else {
            this.b.p.setText(b.a(j.personal__readed_books_view__ranking_total, 20, b.a(this.b.q.f())));
        }
        if (this.a != null) {
            this.a.run();
        }
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.run();
        }
    }
}
