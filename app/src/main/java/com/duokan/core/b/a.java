package com.duokan.core.b;

import android.net.Uri;
import android.text.TextUtils;

public abstract class a {
    public static Uri a(String str) {
        try {
            return Uri.parse(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String b(String str) {
        Uri a = a(str);
        if (a == null) {
            return "";
        }
        String scheme = a.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme;
    }

    public static String c(String str) {
        Uri a = a(str);
        if (a == null) {
            return "";
        }
        String host = a.getHost();
        return TextUtils.isEmpty(host) ? "" : host;
    }

    public static boolean a(String str, String str2, String... strArr) {
        String b = b(str);
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

    public static Uri a(Uri uri, String str) {
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
