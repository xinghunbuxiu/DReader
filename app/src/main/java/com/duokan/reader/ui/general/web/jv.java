package com.duokan.reader.ui.general.web;

import android.content.Intent;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.e;

import java.util.concurrent.Callable;

class jv implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    jv(cg cgVar, String str) {
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
        if (a == null) {
            return Boolean.valueOf(false);
        }
        Intent launchIntentForPackage = this.b.b.getContext().getPackageManager().getLaunchIntentForPackage(a.r);
        if (launchIntentForPackage == null) {
            return Boolean.valueOf(false);
        }
        b.a(this.b.b.getContext()).startActivity(launchIntentForPackage);
        return Boolean.valueOf(true);
    }
}
