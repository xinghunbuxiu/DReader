package com.duokan.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    private static String encryption(byte b) {
        int i = (b & 127) + (b < (byte) 0 ? 128 : 0);
        return (i < 16 ? "0" : "") + Integer.toHexString(i).toLowerCase();
    }

    public static String encryption(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            while (i < digest.length) {
                stringBuffer.append(encryption(digest[i]));
                i++;
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
