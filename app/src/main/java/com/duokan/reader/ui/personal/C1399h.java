package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;

/* renamed from: com.duokan.reader.ui.personal.h */
class C1399h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1396e f8630a;

    C1399h(C1396e c1396e) {
        this.f8630a = c1396e;
    }

    public void run() {
        for (C0800c c0800c : ai.m3980a().m3934i()) {
            if (c0800c.mo1012a(true)) {
                this.f8630a.f8479l.add(c0800c);
            }
        }
        UThread.runOnThread(new C1400i(this));
    }
}
