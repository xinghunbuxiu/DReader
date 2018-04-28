package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.domain.bookshelf.jz;
import com.duokan.reader.domain.bookshelf.ka;

class ri implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f10893a;
    /* renamed from: b */
    final /* synthetic */ jz f10894b;
    /* renamed from: c */
    final /* synthetic */ ka f10895c;
    /* renamed from: d */
    final /* synthetic */ rh f10896d;

    ri(rh rhVar, String str, jz jzVar, ka kaVar) {
        this.f10896d = rhVar;
        this.f10893a = str;
        this.f10894b = jzVar;
        this.f10895c = kaVar;
    }

    public void run() {
        UIdleHandler.addIdleHandler(new rj(this));
    }
}
