package com.duokan.reader.common.c;

import android.net.Uri;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e {
    static final /* synthetic */ boolean a = (!e.class.desiredAssertionStatus());

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.equalsIgnoreCase("txt")) {
            return HTTP.PLAIN_TEXT_TYPE;
        }
        if (substring.equalsIgnoreCase("epub")) {
            return "application/epub+zip";
        }
        if (substring.equalsIgnoreCase("zip")) {
            return "application/zip";
        }
        if (substring.equalsIgnoreCase("rar")) {
            return "application/MyContextWrapper-rar-compressed";
        }
        return null;
    }

    public static boolean b(String str) {
        return !Pattern.compile("\\p{ASCII}*").matcher(str).matches();
    }

    public static String a(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Type");
        String str = "utf-8";
        if (firstHeader != null) {
            Matcher matcher = Pattern.compile(".*charset\\=(.*)", 2).matcher(firstHeader.getValue());
            if (matcher.matches() && matcher.groupCount() > 0) {
                String group = matcher.group(1);
                if (group != null && group.length() > 0) {
                    return group;
                }
            }
        }
        return str;
    }

    public static String a(HttpResponse httpResponse, String str) {
        if (str == null || c(str)) {
            try {
                str = Uri.encode(new String(str.getBytes("ISO-8859-1"), a(httpResponse)), ":/?#[]@!$&'()*+,;=");
            } catch (Exception e) {
                if (!a) {
                    throw new AssertionError();
                }
            }
        }
        return str;
    }

    public static boolean c(String str) {
        return !Pattern.compile("[a-zA-Z0-9\\-\\.\\_\\~\\[\\:\\/\\?\\#\\[\\]\\@\\!\\$\\&\\'\\(\\)\\*\\+\\,\\;\\=\\%]+").matcher(str).matches();
    }
}
