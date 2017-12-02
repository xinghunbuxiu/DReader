package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.core.app.e;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

import java.util.concurrent.Callable;

class gm implements u {
    final /* synthetic */ Callable a;
    final /* synthetic */ boolean b;
    final /* synthetic */ fl c;

    gm(fl flVar, Callable callable, boolean z) {
        this.c = flVar;
        this.a = callable;
        this.b = z;
    }

    public void onQueryAccountOk(a aVar) {
        try {
            this.c.a((e) this.a.call(), this.b, null);
        } catch (Throwable th) {
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.c.getContext(), (CharSequence) str, 0).show();
        }
    }
}
