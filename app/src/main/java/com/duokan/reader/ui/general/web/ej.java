package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.core.ui.AnimUtils;

class ej implements as {
    /* renamed from: a */
    final /* synthetic */ int f7775a;
    /* renamed from: b */
    final /* synthetic */ int f7776b;
    /* renamed from: c */
    final /* synthetic */ boolean f7777c;
    /* renamed from: d */
    final /* synthetic */ ci f7778d;

    ej(ci ciVar, int i, int i2, boolean z) {
        this.f7778d = ciVar;
        this.f7775a = i;
        this.f7776b = i2;
        this.f7777c = z;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7778d.f7581b.scrollPosToTop(AnimUtils.m1932b(this.f7778d.f7581b.getContext(), (float) this.f7775a), AnimUtils.m1932b(this.f7778d.f7581b.getContext(), (float) this.f7776b), this.f7777c);
    }
}
