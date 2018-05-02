package com.duokan.core.p027b;

import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.duokan.core.b.a */
public abstract class C0324a {
    /* renamed from: a */
    public static Uri m734a(String str) {
        try {
            return Uri.parse(str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m736b(String str) {
        Uri a = C0324a.m734a(str);
        if (a == null) {
            return "";
        }
        String scheme = a.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme;
    }

    /* renamed from: c */
    public static String m737c(String str) {
        Uri a = C0324a.m734a(str);
        if (a == null) {
            return "";
        }
        String host = a.getHost();
        return TextUtils.isEmpty(host) ? "" : host;
    }

    /* renamed from: a */
    public static boolean m735a(String str, String str2, String... strArr) {
        String b = C0324a.m736b(str);
        if (b.equalsIgnoreCase(str2)) {
            return true;
        }
        for (String equalsIgnoreCase : strArr) {
            if (b.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Uri m733a(Uri uri, String str) {
        if (uri == null || TextUtils.isEmpty(str)) {
            return uri;
        }
        Object encodedFragment = uri.getEncodedFragment();
        if (TextUtils.isEmpty(encodedFragment)) {
            return uri.buildUpon().encodedFragment(str).build();
        }
        return uri.buildUpon().encodedFragment(encodedFragment + "&" + str).build();
    }
}
