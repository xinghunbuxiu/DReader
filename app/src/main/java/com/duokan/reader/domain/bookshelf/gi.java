package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.document.epub.C0809b;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

class gi implements C0809b {
    /* renamed from: a */
    final /* synthetic */ fp f3229a;
    /* renamed from: b */
    private final String f3230b;
    /* renamed from: c */
    private final String f3231c;
    /* renamed from: d */
    private final String f3232d;
    /* renamed from: e */
    private final String f3233e;

    public gi(fp fpVar, String str, String str2, String str3) {
        boolean containsKey;
        this.f3229a = fpVar;
        this.f3230b = str;
        this.f3231c = str2;
        this.f3232d = str3;
        if (!TextUtils.isEmpty(str3)) {
            str = str + "." + str3;
        }
        af d = fpVar.br();
        if (d.m861b()) {
            containsKey = ((ConcurrentHashMap) d.m858a()).containsKey(str);
        } else {
            containsKey = new File(fpVar.m4222e(), str).exists();
        }
        if (!containsKey) {
            str = "/";
        }
        this.f3233e = str;
    }

    /* renamed from: a */
    public String mo1056a() {
        return this.f3230b;
    }

    /* renamed from: b */
    public String mo1057b() {
        return this.f3231c;
    }

    /* renamed from: c */
    public String mo1058c() {
        return this.f3233e;
    }

    /* renamed from: d */
    public boolean m4534d() {
        return TextUtils.equals(this.f3233e, "/");
    }
}
