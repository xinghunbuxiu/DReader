package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.domain.account.C0672a;

class gd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0672a f3220a;
    /* renamed from: b */
    final /* synthetic */ Runnable f3221b;
    /* renamed from: c */
    final /* synthetic */ fp f3222c;

    gd(fp fpVar, C0672a c0672a, Runnable runnable) {
        this.f3222c = fpVar;
        this.f3220a = c0672a;
        this.f3221b = runnable;
    }

    public void run() {
        new ge(this, C0630c.f2119a).open();
    }
}
