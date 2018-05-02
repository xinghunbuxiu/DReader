package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.C0641o;

class ku {
    /* renamed from: a */
    public final String f8116a;
    /* renamed from: b */
    public final String f8117b;

    private ku(String str, String str2) {
        this.f8117b = str;
        this.f8116a = str2;
    }

    /* renamed from: a */
    public static ku m11274a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("//")) {
            return new ku(C0641o.m2934i().m2999z() + "/phone/" + str, str);
        }
        String substring = str.substring(2);
        return new ku((substring.startsWith("www.duokan.com") ? "https://" : "http://") + substring, substring);
    }
}
