package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;

import java.util.Locale;
import java.util.regex.Pattern;

public class y {
    private static final Pattern a = Pattern.compile("-");
    private final String b;
    private final int c;
    private final String d;

    public y(String str) {
        String[] split = a.split(str);
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
            this.b = str;
            this.c = parseInt;
            this.d = str2;
            return;
        }
        this.b = str;
        this.c = 0;
        this.d = "";
    }

    private y(String str, int i, String str2) {
        this.b = str;
        if (TextUtils.isEmpty(str2)) {
            this.c = 0;
            this.d = "";
            return;
        }
        this.c = i;
        this.d = str2;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public static y a(String str, int i, String str2) {
        return new y(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        return TextUtils.equals(this.b, ((y) obj).b);
    }

    public String toString() {
        if (this.c == 0) {
            return this.b;
        }
        return String.format(Locale.getDefault(), "%s-%d-%s", new Object[]{this.b, Integer.valueOf(this.c), this.d});
    }
}
