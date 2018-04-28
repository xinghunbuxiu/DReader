package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;

class fp implements at {
    /* renamed from: a */
    final /* synthetic */ gx f10165a;
    /* renamed from: b */
    final /* synthetic */ fo f10166b;

    fp(fo foVar, gx gxVar) {
        this.f10166b = foVar;
        this.f10165a = gxVar;
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        if (asVar == this.f10165a.getPageDrawable()) {
            this.f10165a.m14300f();
            this.f10166b.f10164a.m9997a(this.f10165a.getPage());
        }
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
    }
}
