package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.domain.bookshelf.o */
class C0830o implements C0806u {
    /* renamed from: a */
    final /* synthetic */ C0829n f3574a;

    C0830o(C0829n c0829n) {
        this.f3574a = c0829n;
    }

    /* renamed from: a */
    public void mo1044a() {
        UThread.runOnThread(new C0831p(this));
    }

    /* renamed from: b */
    public void mo1045b() {
        UThread.runOnThread(new C0832q(this));
    }

    /* renamed from: c */
    public void mo1046c() {
        UThread.runOnThread(new C0833r(this));
    }
}
