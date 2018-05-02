package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.sys.af;
import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;

/* renamed from: com.duokan.reader.ui.personal.g */
class C1398g implements ad {
    /* renamed from: a */
    final /* synthetic */ C0800c f8600a;
    /* renamed from: b */
    final /* synthetic */ C1397f f8601b;

    C1398g(C1397f c1397f, C0800c c0800c) {
        this.f8601b = c1397f;
        this.f8600a = c0800c;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        C0342j a = ja.m10832a(this.f8601b.f8531a.getContext(), "", this.f8601b.f8531a.getResources().getString(C0258j.personal__auto_buy_view__deleting), true, true);
        this.f8600a.mo1009a(new af(Boolean.valueOf(false)));
        this.f8600a.aN();
        if (this.f8600a.mo1012a(true)) {
            be.m10286a(this.f8601b.f8531a.getContext(), C0258j.personal__auto_buy_view__delete_fail, 0).show();
        } else {
            this.f8601b.f8531a.f8479l.remove(this.f8600a);
            this.f8601b.f8531a.mo1901a(false);
            be.m10286a(this.f8601b.f8531a.getContext(), C0258j.personal__auto_buy_view__delete_succeed, 0).show();
        }
        a.dismiss();
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
