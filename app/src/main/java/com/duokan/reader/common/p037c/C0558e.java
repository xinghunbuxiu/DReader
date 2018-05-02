package com.duokan.reader.common.p037c;

import android.net.Uri;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.common.c.e */
public class C0558e {
    /* renamed from: a */
    static final /* synthetic */ boolean f1838a = (!C0558e.class.desiredAssertionStatus());

    /* renamed from: a */
    public static String m2465a(String str) {
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
            return "application/x-rar-compressed";
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m2468b(String str) {
        return !Pattern.compile("\\p{ASCII}*").matcher(str).matches();
    }

    /* renamed from: a */
    public static String m2466a(HttpResponse httpResponse) {
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

    /* renamed from: a */
    public static String m2467a(HttpResponse httpResponse, String str) {
        if (str == null || C0558e.m2469c(str)) {
            try {
                str = Uri.encode(new String(str.getBytes("ISO-8859-1"), C0558e.m2466a(httpResponse)), ":/?#[]@!$&'()*+,;=");
            } catch (Exception e) {
                if (!f1838a) {
                    throw new AssertionError();
                }
            }
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m2469c(String str) {
        return !Pattern.compile("[a-zA-Z0-9\\-\\.\\_\\~\\[\\:\\/\\?\\#\\[\\]\\@\\!\\$\\&\\'\\(\\)\\*\\+\\,\\;\\=\\%]+").matcher(str).matches();
    }
}
