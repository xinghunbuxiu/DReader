package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.C0543b;

class id implements nd {
    /* renamed from: a */
    final /* synthetic */ Runnable f8703a;
    /* renamed from: b */
    final /* synthetic */ hy f8704b;

    id(hy hyVar, Runnable runnable) {
        this.f8704b = hyVar;
        this.f8703a = runnable;
    }

    /* renamed from: a */
    public void mo1925a() {
        this.f8704b.b.setLeftTitle(String.format(DkApp.get().getString(C0258j.personal__readed_books_view__title), new Object[]{Long.valueOf(this.f8704b.f8690r.mo1906b())}));
        if (this.f8704b.f8690r.mo1910f() == 0.0d) {
            this.f8704b.f8689q.setText(this.f8704b.f8683a.getString(C0258j.personal__experience_view__ranking_total_low));
        } else {
            this.f8704b.f8689q.setText(C0543b.m2417a(C0258j.personal__readed_books_view__ranking_total, 20, C0543b.m2420a(this.f8704b.f8690r.mo1910f())));
        }
        if (this.f8703a != null) {
            this.f8703a.run();
        }
    }

    /* renamed from: a */
    public void mo1926a(String str) {
        if (this.f8703a != null) {
            this.f8703a.run();
        }
    }
}
