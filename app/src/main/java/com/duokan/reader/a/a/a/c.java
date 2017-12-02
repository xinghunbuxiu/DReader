package com.duokan.reader.a.a.a;

import org.apache.http.protocol.HTTP;

public class c {
    private static String[] a = null;
    private static c b = null;

    public c() {
        a = new String[21];
        a[0] = "GB2312";
        a[1] = "GBK";
        a[2] = "GB18030";
        a[3] = HTTP.ASCII;
        a[11] = "ISO2022CN_GB";
        a[4] = "BIG5";
        a[5] = "EUC-TW";
        a[6] = HTTP.UTF_8;
        a[7] = "UTF-16BE";
        a[8] = "UTF-16LE";
        a[10] = "ISO2022CN_CNS";
        a[9] = "ISO2022CN";
        a[12] = "EUC_KR";
        a[13] = "MS949";
        a[14] = "ISO2022KR";
        a[15] = "Johab";
        a[16] = "SJIS";
        a[17] = "EUC_JP";
        a[18] = "ISO2022JP";
        a[19] = HTTP.ASCII;
        a[20] = "ISO8859_1";
    }

    public String a(int i) {
        if (i < 0 || i >= a.length) {
            return "Unknown";
        }
        return a[i];
    }
}
