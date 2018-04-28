package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;
import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ap;
import java.util.concurrent.Semaphore;

class gs implements as {
    /* renamed from: a */
    final /* synthetic */ C0800c f7899a;
    /* renamed from: b */
    final /* synthetic */ String f7900b;
    /* renamed from: c */
    final /* synthetic */ Semaphore f7901c;
    /* renamed from: d */
    final /* synthetic */ gr f7902d;

    gs(gr grVar, C0800c c0800c, String str, Semaphore semaphore) {
        this.f7902d = grVar;
        this.f7899a = c0800c;
        this.f7900b = str;
        this.f7901c = semaphore;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (C0559f.m2476b().m2484c()) {
            ap apVar = new ap(this.f7902d.f7898b.f7581b.getContext());
            apVar.setOkLabelResid(C0258j.general__shared__continue);
            apVar.setCancelLabel(C0258j.general__shared__cancel);
            apVar.setTitle(C0258j.bookshelf__book__download_dialog__title);
            apVar.setPrompt(C0258j.bookshelf__book__download_dialog__serial_prompt);
            apVar.open(new gt(this));
            return;
        }
        this.f7899a.m4198a(this.f7899a.m4225f(), this.f7900b, "", "", true, new af(Boolean.valueOf(true)));
        this.f7901c.release();
    }
}
