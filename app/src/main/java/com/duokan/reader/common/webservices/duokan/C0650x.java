package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.duokan.reader.common.webservices.duokan.x */
public class C0650x {
    /* renamed from: a */
    private static final Pattern f2179a = Pattern.compile("-");
    /* renamed from: b */
    private final String f2180b;
    /* renamed from: c */
    private final int f2181c;
    /* renamed from: d */
    private final String f2182d;

    public C0650x(String str) {
        String[] split = f2179a.split(str);
        if (split.length >= 3) {
            int parseInt;
            String str2;
            try {
                String str3 = split[0];
                parseInt = Integer.parseInt(split[1]);
                str2 = split[2];
                str = str3;
            } catch (Exception e) {
                str2 = "";
                parseInt = 0;
            }
            this.f2180b = str;
            this.f2181c = parseInt;
            this.f2182d = str2;
            return;
        }
        this.f2180b = str;
        this.f2181c = 0;
        this.f2182d = "";
    }

    private C0650x(String str, int i, String str2) {
        this.f2180b = str;
        if (TextUtils.isEmpty(str2)) {
            this.f2181c = 0;
            this.f2182d = "";
            return;
        }
        this.f2181c = i;
        this.f2182d = str2;
    }

    /* renamed from: a */
    public String m3046a() {
        return this.f2180b;
    }

    /* renamed from: b */
    public int m3047b() {
        return this.f2181c;
    }

    /* renamed from: a */
    public static C0650x m3045a(String str, int i, String str2) {
        return new C0650x(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0650x)) {
            return false;
        }
        return TextUtils.equals(this.f2180b, ((C0650x) obj).f2180b);
    }

    public String toString() {
        if (this.f2181c == 0) {
            return this.f2180b;
        }
        return String.format(Locale.getDefault(), "%s-%d-%s", new Object[]{this.f2180b, Integer.valueOf(this.f2181c), this.f2182d});
    }
}
