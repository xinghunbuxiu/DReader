package com.duokan.reader.common.cache;

import android.text.TextUtils;

public class i implements q {
    public static final i a = new i();

    public /* synthetic */ String a(Object obj) {
        return b((String) obj);
    }

    public /* synthetic */ boolean b(Object obj) {
        return a((String) obj);
    }

    public /* synthetic */ Object d(String str) {
        return c(str);
    }

    public final boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public final String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public final String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
