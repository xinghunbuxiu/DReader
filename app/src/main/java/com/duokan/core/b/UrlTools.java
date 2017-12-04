package com.duokan.core.b;

import android.net.Uri;
import android.text.TextUtils;

public abstract class UrlTools {
    public static Uri parse(String str) {
        try {
            return Uri.parse(str);
        } catch (Throwable th) {
            return null;
        }
    }

    //协议 http or https ssl
    public static String getScheme(String url) {
        Uri a = parse(url);
        if (a == null) {
            return "";
        }
        String scheme = a.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme;
    }

    //域名
    public static String getHost(String url) {
        Uri u = parse(url);
        if (u == null) {
            return "";
        }
        String host = u.getHost();
        return TextUtils.isEmpty(host) ? "" : host;
    }

    public static boolean compScheme(String url, String scheme2, String... schemes) {
        String scheme = getScheme(url);
        if (scheme.equalsIgnoreCase(scheme2)) {
            return true;
        }
        for (String scheme3 : schemes) {
            if (scheme.equalsIgnoreCase(scheme3)) {
                return true;
            }
        }
        return false;
    }

    public static Uri resetUrl(Uri uri, String param) {
        if (uri == null || TextUtils.isEmpty(param)) {
            return uri;
        }
        //返回此URL的编码片段，像"abc"对http://host/#abc
        String encodedFragment = uri.getEncodedFragment();
        if (TextUtils.isEmpty(encodedFragment)) {
            return uri.buildUpon().encodedFragment(param).build();
        }
        return uri.buildUpon().encodedFragment(encodedFragment + "&" + param).build();
    }
}
