package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class fg implements C0666x {
    /* renamed from: a */
    final /* synthetic */ int f3994a;
    /* renamed from: b */
    final /* synthetic */ int f3995b;
    /* renamed from: c */
    final /* synthetic */ fi f3996c;
    /* renamed from: d */
    final /* synthetic */ ex f3997d;

    fg(ex exVar, int i, int i2, fi fiVar) {
        this.f3997d = exVar;
        this.f3994a = i;
        this.f3995b = i2;
        this.f3996c = fiVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new fh(this, C0629b.f2117a, new al(c0672a)).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3996c.mo1930a(str);
    }
}
