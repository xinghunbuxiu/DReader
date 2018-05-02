package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.ui.general.be;

class ky implements b {
    final /* synthetic */ kx a;

    ky(kx kxVar) {
        this.a = kxVar;
    }

    public void a(a aVar) {
        this.a.c.a.f();
    }

    public void a(a aVar, String str) {
        this.a.c.a.e();
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.c.a.b, (CharSequence) str, 0).show();
        }
    }
}
