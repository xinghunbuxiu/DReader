package com.duokan.reader.ui.general;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.c;

public class n {
    private final String a;
    private final String b;

    public n(c cVar, String str) {
        this.a = cVar == null ? "" : cVar.H();
        this.b = str;
    }

    public String a() {
        if (TextUtils.isEmpty(this.a)) {
            return this.b;
        }
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
