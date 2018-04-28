package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.store.aq;

class jb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ja f8030a;
    /* renamed from: b */
    final /* synthetic */ af f8031b;
    /* renamed from: c */
    final /* synthetic */ String f8032c;
    /* renamed from: d */
    final /* synthetic */ String f8033d;
    /* renamed from: e */
    final /* synthetic */ int f8034e;
    /* renamed from: f */
    final /* synthetic */ ix f8035f;

    jb(ix ixVar, ja jaVar, af afVar, String str, String str2, int i) {
        this.f8035f = ixVar;
        this.f8030a = jaVar;
        this.f8031b = afVar;
        this.f8032c = str;
        this.f8033d = str2;
        this.f8034e = i;
    }

    public void run() {
        this.f8030a.dismiss();
        if (this.f8031b.m861b()) {
            ReaderFeature readerFeature = (ReaderFeature) this.f8035f.f8022b.f7581b.getContext().queryFeature(ReaderFeature.class);
            ((C0800c) this.f8031b.m858a()).m4237k(this.f8033d);
            if (((C0800c) this.f8031b.m858a()).mo1038k()) {
                aq.m15259a(readerFeature, (C0800c) this.f8031b.m858a(), (long) this.f8034e);
            } else {
                readerFeature.openBook((C0800c) this.f8031b.m858a());
            }
            this.f8035f.f8022b.f7581b.web_notifyWeb(this.f8032c, 0, "open", Boolean.valueOf(true));
            return;
        }
        this.f8035f.f8022b.f7581b.web_notifyWeb(this.f8032c, 0, "open", Boolean.valueOf(false));
    }
}
