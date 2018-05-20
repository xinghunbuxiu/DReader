package com.duokan.core.p027b;

import android.net.Uri;
import android.text.TextUtils;


public abstract class UrlTools {

    public static Uri parse(String str) {
        return Uri.parse(str);
    }


    public static String getScheme(String str) {
        Uri uri = parse(str);
        if (uri == null) {
            return "";
        }
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme;
    }


    public static String getHost(String str) {
        Uri uri = parse(str);
        if (uri == null) {
            return "";
        }
        String host = uri.getHost();
        return TextUtils.isEmpty(host) ? "" : host;
    }


    public static boolean equalsIgnoreCase(String url, String scheme1, String... schemes) {
        String scheme = getScheme(url);
        if (scheme.equalsIgnoreCase(scheme1)) {
            return true;
        }
        for (String equalsIgnoreCase : schemes) {
            if (scheme.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }


    public static Uri encodedFragment(Uri uri, String str) {
        if (uri == null || TextUtils.isEmpty(str)) {
            return uri;
        }
        String encodedFragment = uri.getEncodedFragment();
        if (TextUtils.isEmpty(encodedFragment)) {
            return uri.buildUpon().encodedFragment(str).build();
        }
        return uri.buildUpon().encodedFragment(encodedFragment + "&" + str).build();
    }
}
