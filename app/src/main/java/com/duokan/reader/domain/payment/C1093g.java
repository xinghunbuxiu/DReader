package com.duokan.reader.domain.payment;

import android.app.Activity;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.payment.g */
public class C1093g extends C1085q {
    /* renamed from: a */
    public String mo1499a() {
        return "MIPAY";
    }

    /* renamed from: a */
    public void mo1500a(C1089s c1089s, C1097r c1097r) {
        Activity topActivity = DkApp.get().getTopActivity();
        if (topActivity instanceof Activity) {
            C1091e.m8369a(topActivity, c1089s, new C1095h(this, c1097r, c1089s));
        } else {
            c1097r.mo1509b(this, c1089s, "");
        }
    }
}
