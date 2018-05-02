package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.document.epub.b;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

class go implements b {
    final /* synthetic */ fv a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public go(fv fvVar, String str, String str2, String str3) {
        boolean containsKey;
        this.a = fvVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        if (!TextUtils.isEmpty(str3)) {
            str = str + "." + str3;
        }
        af d = fvVar.bp();
        if (d.b()) {
            containsKey = ((ConcurrentHashMap) d.a()).containsKey(str);
        } else {
            containsKey = new File(fvVar.e(), str).exists();
        }
        if (!containsKey) {
            str = "/";
        }
        this.e = str;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.e;
    }

    public boolean d() {
        return TextUtils.equals(this.e, "/");
    }
}
