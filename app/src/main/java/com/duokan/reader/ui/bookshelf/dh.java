package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;

class dh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f6331a;
    /* renamed from: b */
    final /* synthetic */ boolean f6332b;
    /* renamed from: c */
    final /* synthetic */ int f6333c;
    /* renamed from: d */
    final /* synthetic */ de f6334d;

    dh(de deVar, C0800c c0800c, boolean z, int i) {
        this.f6334d = deVar;
        this.f6331a = c0800c;
        this.f6332b = z;
        this.f6333c = i;
    }

    public void run() {
        boolean h;
        int i = 0;
        C1068i b = it.m4692a().m4726b(this.f6331a.m4222e());
        if (b != null) {
            h = b.m2293h();
            i = Math.round((((float) b.m8210F()) / ((float) b.m8207C())) * 10000.0f);
        } else {
            h = false;
        }
        if (this.f6332b != h || this.f6333c != i) {
            UThread.runOnThread(new di(this, h, i));
        }
    }
}
