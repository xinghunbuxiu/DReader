package com.duokan.reader.domain.account;

import android.text.TextUtils;

class v extends g {
    final /* synthetic */ AnonymousAccount a;

    v(AnonymousAccount anonymousAccount) {
        this.a = anonymousAccount;
    }

    public String a() {
        String i = i.f().i();
        if (TextUtils.isEmpty(i) || i.length() < 10) {
            return null;
        }
        return i.substring(0, 10);
    }

    public String b() {
        return "";
    }
}
