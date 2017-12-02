package com.duokan.reader.domain.payment;

import android.app.Activity;

import com.duokan.reader.DkApp;

public class g extends q {
    public String a() {
        return "MIPAY";
    }

    public void a(s sVar, r rVar) {
        Activity topActivity = DkApp.get().getTopActivity();
        if (topActivity instanceof Activity) {
            e.a(topActivity, sVar, new h(this, rVar, sVar));
        } else {
            rVar.b(this, sVar, "");
        }
    }
}
