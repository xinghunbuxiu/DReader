package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

class eg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f3098a;
    /* renamed from: b */
    final /* synthetic */ Runnable f3099b;
    /* renamed from: c */
    final /* synthetic */ ee f3100c;

    eg(ee eeVar, ag agVar, Runnable runnable) {
        this.f3100c = eeVar;
        this.f3098a = agVar;
        this.f3099b = runnable;
    }

    public void run() {
        this.f3100c.aV().mo1102e().m8704a(this.f3100c.m4156I(), false, false, -1, -1, -1, new eh(this));
    }
}
