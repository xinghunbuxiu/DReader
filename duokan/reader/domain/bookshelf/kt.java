package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.ui.general.be;

class kt implements b {
    final /* synthetic */ ks a;

    kt(ks ksVar) {
        this.a = ksVar;
    }

    public void a(a aVar) {
        this.a.d.a.c();
    }

    public void a(a aVar, String str) {
        this.a.d.a.e();
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.d.a.b, (CharSequence) str, 0).show();
        }
    }
}
