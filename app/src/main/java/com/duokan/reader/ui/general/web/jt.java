package com.duokan.reader.ui.general.web;

import android.content.Intent;
import android.text.TextUtils;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.c;
import com.duokan.reader.domain.ad.e;
import com.duokan.reader.domain.ad.g;
import com.duokan.reader.domain.ad.r;
import com.duokan.reader.domain.ad.x;

import java.util.concurrent.Callable;

class jt implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    jt(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (!ReaderEnv.get().onMiui()) {
            return Boolean.valueOf(false);
        }
        e a = e.a(this.a);
        if (a == null || TextUtils.isEmpty(a.r)) {
            return Boolean.valueOf(false);
        }
        this.b.b.mAdLifecycleManager.b(a.r, new ju(this, a));
        if (Intent.parseUri(new c(this.b.b.getContext()).a(a.r), 0) == null) {
            return Boolean.valueOf(false);
        }
        g.a().b(a);
        if (!x.a(this.b.b.getContext(), a.r)) {
            this.b.b.mAdLifecycleManager.a(a);
            if (this.b.b.mAdSdkService == null) {
                this.b.b.mAdSdkService = new r(this.b.b.mAdLifecycleManager);
            }
            this.b.b.mAdSdkService.a(a);
        }
        return Boolean.valueOf(true);
    }
}
