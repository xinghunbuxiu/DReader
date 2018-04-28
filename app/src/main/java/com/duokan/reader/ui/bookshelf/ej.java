package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.ai;

class ej implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f6384a;
    /* renamed from: b */
    final /* synthetic */ String f6385b;
    /* renamed from: c */
    final /* synthetic */ ec f6386c;

    ej(ec ecVar, boolean z, String str) {
        this.f6386c = ecVar;
        this.f6384a = z;
        this.f6385b = str;
    }

    public void run() {
        this.f6386c.f6376h.setVisibility(8);
        if (this.f6384a) {
            ai.m3980a().m3902a(this.f6386c.f6369a, this.f6385b);
            this.f6386c.f6375g.setText(this.f6385b);
            this.f6386c.f6369a.aN();
            return;
        }
        this.f6386c.f6375g.setText(this.f6386c.f6369a.m3770k());
    }
}
