package com.duokan.reader.domain.account;

import android.text.TextUtils;

/* renamed from: com.duokan.reader.domain.account.y */
class C0742y extends C0705g {
    /* renamed from: a */
    final /* synthetic */ AnonymousAccount f2510a;

    C0742y(AnonymousAccount anonymousAccount) {
        this.f2510a = anonymousAccount;
    }

    /* renamed from: a */
    public String mo871a() {
        String i = C0709k.m3476a().m3514i();
        if (TextUtils.isEmpty(i) || i.length() < 10) {
            return null;
        }
        return i.substring(0, 10);
    }

    /* renamed from: b */
    public String mo872b() {
        return "";
    }
}
