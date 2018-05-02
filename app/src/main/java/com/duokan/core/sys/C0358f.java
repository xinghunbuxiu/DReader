package com.duokan.core.sys;

import android.text.TextUtils;

/* renamed from: com.duokan.core.sys.f */
public abstract class C0358f {
    /* renamed from: a */
    private final int f722a;
    /* renamed from: b */
    private final String f723b;
    /* renamed from: c */
    private final String f724c;

    /* renamed from: a */
    public abstract int mo775a(C0358f c0358f);

    public C0358f(String str, String str2) {
        this(str, str2, TextUtils.isEmpty(str) ? 0 : str.hashCode());
    }

    public C0358f(String str, String str2, int i) {
        this.f723b = str;
        this.f724c = str2;
        this.f722a = i;
    }

    /* renamed from: a */
    public String m1022a() {
        return this.f724c;
    }

    public int hashCode() {
        return this.f722a;
    }
}
