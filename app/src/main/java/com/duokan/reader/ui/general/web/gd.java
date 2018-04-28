package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.ui.store.comment.C1490n;

class gd implements C0517a<C1490n> {
    /* renamed from: a */
    static final /* synthetic */ boolean f7879a = (!StorePageController.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ String f7880b;
    /* renamed from: c */
    final /* synthetic */ gc f7881c;

    gd(gc gcVar, String str) {
        this.f7881c = gcVar;
        this.f7880b = str;
    }

    /* renamed from: a */
    public void m11142a(C1490n c1490n) {
        this.f7881c.f7878a.f7877b.f7581b.web_notifyWeb(this.f7880b, 0, "operation", Boolean.valueOf(c1490n.f11437d), "score", Integer.valueOf(c1490n.f11434a), "title", c1490n.f11435b, "content", c1490n.f11436c);
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        if (!f7879a) {
            throw new AssertionError();
        }
    }
}
