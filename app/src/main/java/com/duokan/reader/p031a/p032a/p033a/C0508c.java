package com.duokan.reader.p031a.p032a.p033a;

import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.a.a.a.c */
public class C0508c {
    /* renamed from: a */
    private static String[] f1714a = null;
    /* renamed from: b */
    private static C0508c f1715b = null;

    public C0508c() {
        f1714a = new String[21];
        f1714a[0] = "GB2312";
        f1714a[1] = "GBK";
        f1714a[2] = "GB18030";
        f1714a[3] = HTTP.ASCII;
        f1714a[11] = "ISO2022CN_GB";
        f1714a[4] = "BIG5";
        f1714a[5] = "EUC-TW";
        f1714a[6] = HTTP.UTF_8;
        f1714a[7] = "UTF-16BE";
        f1714a[8] = "UTF-16LE";
        f1714a[10] = "ISO2022CN_CNS";
        f1714a[9] = "ISO2022CN";
        f1714a[12] = "EUC_KR";
        f1714a[13] = "MS949";
        f1714a[14] = "ISO2022KR";
        f1714a[15] = "Johab";
        f1714a[16] = "SJIS";
        f1714a[17] = "EUC_JP";
        f1714a[18] = "ISO2022JP";
        f1714a[19] = HTTP.ASCII;
        f1714a[20] = "ISO8859_1";
    }

    /* renamed from: a */
    public String m2187a(int i) {
        if (i < 0 || i >= f1714a.length) {
            return "Unknown";
        }
        return f1714a[i];
    }
}
