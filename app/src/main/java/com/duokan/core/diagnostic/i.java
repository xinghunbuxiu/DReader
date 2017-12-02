package com.duokan.core.diagnostic;

import android.text.TextUtils;

import com.duokan.core.sys.j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class i {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private final Thread b = j.a();
    private final long c = System.currentTimeMillis();
    private final LogLevel d;
    private final String e;
    private final String f;
    private final String g;

    public i(LogLevel logLevel, String str, String str2) {
        String str3;
        this.d = logLevel;
        this.e = str;
        this.f = str2;
        Locale locale = Locale.getDefault();
        String str4 = "[%s]%s";
        Object[] objArr = new Object[2];
        objArr[0] = this.d.name();
        if (TextUtils.isEmpty(this.e)) {
            str3 = "";
        } else {
            str3 = String.format(Locale.getDefault(), "[%s]", new Object[]{this.e});
        }
        objArr[1] = str3;
        this.g = String.format(locale, str4, objArr);
    }

    public String toString() {
        String format = a.format(new Date(this.c));
        return String.format(Locale.getDefault(), "%s%s //@%s, %s", new Object[]{this.g, this.f, this.b.toString(), format});
    }
}
