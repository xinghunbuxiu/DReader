package com.duokan.reader.ui.general;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;

/* renamed from: com.duokan.reader.ui.general.n */
public class C1342n {
    /* renamed from: a */
    private final String f7535a;
    /* renamed from: b */
    private final String f7536b;

    public C1342n(C0800c c0800c, String str) {
        this.f7535a = c0800c == null ? "" : c0800c.m4156I();
        this.f7536b = str;
    }

    /* renamed from: a */
    public String m10939a() {
        if (TextUtils.isEmpty(this.f7535a)) {
            return this.f7536b;
        }
        return this.f7535a;
    }

    /* renamed from: b */
    public String m10940b() {
        return this.f7536b;
    }
}
