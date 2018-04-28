package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.C0801y;

class qt implements C0801y {
    /* renamed from: a */
    final /* synthetic */ qr f10873a;

    qt(qr qrVar) {
        this.f10873a = qrVar;
    }

    /* renamed from: a */
    public void mo1001a(C0800c c0800c, boolean z) {
        if (z) {
            this.f10873a.f9279c.mo2103b(new qu(this, c0800c));
        }
    }

    /* renamed from: a */
    public void mo1000a(C0800c c0800c, String str) {
        if (this.f10873a.f9282f == c0800c) {
        }
    }

    /* renamed from: a */
    public void mo999a(C0800c c0800c) {
        if (this.f10873a.f9282f == c0800c) {
            this.f10873a.runAfterActive(new qw(this));
        }
    }

    /* renamed from: b */
    public void mo1003b(C0800c c0800c, boolean z) {
        if (this.f10873a.f9282f == c0800c && z) {
            this.f10873a.runAfterActive(new qx(this));
        }
    }

    /* renamed from: b */
    public void mo1002b(C0800c c0800c, String str) {
        if (this.f10873a.f9282f == c0800c) {
        }
    }
}
