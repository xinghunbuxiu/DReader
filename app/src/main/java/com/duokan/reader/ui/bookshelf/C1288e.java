package com.duokan.reader.ui.bookshelf;

import com.duokan.core.ui.AnimUtils;

/* renamed from: com.duokan.reader.ui.bookshelf.e */
class C1288e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1286d f6366a;

    C1288e(C1286d c1286d) {
        this.f6366a = c1286d;
    }

    public void run() {
        if (this.f6366a.f6319a.f6237a != null) {
            this.f6366a.f6319a.f6237a.m9696c();
        }
        AnimUtils.hideAnimation(this.f6366a.f6319a.f6238b, new C1289f(this));
    }
}
