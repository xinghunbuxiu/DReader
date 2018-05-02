package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.bookshelf.d */
class C0802d implements C0801y {
    /* renamed from: a */
    final /* synthetic */ av f2997a;
    /* renamed from: b */
    final /* synthetic */ C0800c f2998b;

    C0802d(C0800c c0800c, av avVar) {
        this.f2998b = c0800c;
        this.f2997a = avVar;
    }

    /* renamed from: a */
    public void mo1001a(C0800c c0800c, boolean z) {
    }

    /* renamed from: a */
    public void mo1000a(C0800c c0800c, String str) {
    }

    /* renamed from: a */
    public void mo999a(C0800c c0800c) {
    }

    /* renamed from: b */
    public void mo1003b(C0800c c0800c, boolean z) {
        UThread.post(new C0804e(this));
    }

    /* renamed from: b */
    public void mo1002b(C0800c c0800c, String str) {
    }
}
