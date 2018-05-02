package com.duokan.core.sys;

import android.text.TextUtils;

public abstract class f {
    private final int a;
    private final String b;
    private final String c;

    public abstract int a(f fVar);

    public f(String str, String str2) {
        this(str, str2, TextUtils.isEmpty(str) ? 0 : str.hashCode());
    }

    public f(String str, String str2, int i) {
        this.b = str;
        this.c = str2;
        this.a = i;
    }

    public String a() {
        return this.c;
    }

    public int hashCode() {
        return this.a;
    }
}
