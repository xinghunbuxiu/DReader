package com.duokan.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Deprecated
/* renamed from: com.duokan.common.h */
public class C0266h {
    /* renamed from: a */
    private static String m596a(byte b) {
        int i = (b & 127) + (b < (byte) 0 ? 128 : 0);
        return (i < 16 ? "0" : "") + Integer.toHexString(i).toLowerCase();
    }

    /* renamed from: a */
    public static String m597a(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            while (i < digest.length) {
                stringBuffer.append(C0266h.m596a(digest[i]));
                i++;
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
